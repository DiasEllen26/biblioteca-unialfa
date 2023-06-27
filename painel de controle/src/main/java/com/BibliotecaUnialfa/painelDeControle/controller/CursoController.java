package com.BibliotecaUnialfa.painelDeControle.controller;

import com.BibliotecaUnialfa.painelDeControle.model.Curso;
import com.BibliotecaUnialfa.painelDeControle.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("curso")
public class CursoController {
    @Autowired
    private CursoService service;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de cursos");
        model.addAttribute("ListaDeCursos", service.listarTodos());
        return "curso/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Curso curso) {
        model.addAttribute("boasVindas", "Cadastro de cursos");
        return "curso/formulario";
    }

    @PostMapping("/cadastrar")
    public String salvar(@Valid Curso curso, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "curso/formulario";
        }
        service.salvar(curso);
        return "redirect:/curso/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("boasVindas", "Cadastro de cursos");
        model.addAttribute("curso", service.buscarPorId(id));
        return "curso/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String remover(@PathVariable Long id) {
        service.deletarPorId(id);
        return "redirect:/curso/lista";
    }
}