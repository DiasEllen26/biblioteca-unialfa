package com.BibliotecaUnialfa.painelDeControle.controller;

import com.BibliotecaUnialfa.painelDeControle.model.Aluno;
import com.BibliotecaUnialfa.painelDeControle.service.AlunoService;
import com.BibliotecaUnialfa.painelDeControle.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService service;
    @Autowired
    private CursoService serviceCurso;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de alunos");
        model.addAttribute("listaDeAlunos", service.listarTodos());
        return "aluno/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Aluno aluno) {
        model.addAttribute("boasVindas", "Cadastro de alunos");
        model.addAttribute("cursos",serviceCurso.listarTodos());
        return "aluno/formulario";
    }

    @PostMapping("/cadastrar")
    public String salvar(@Valid Aluno aluno, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("boasVindas", "Cadastro de alunos");
            model.addAttribute("cursos",serviceCurso.listarTodos());
            return "aluno/formulario";
        }
        service.salvar(aluno);
        return "redirect:/aluno/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("boasVindas", "Cadastro de alunos");
        model.addAttribute("aluno", service.buscarPorId(id));
        model.addAttribute("cursos",serviceCurso.listarTodos());
        return "aluno/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String remover(@PathVariable Long id) {
        service.deletarPorId(id);
        return "redirect:/aluno/lista";
    }
}