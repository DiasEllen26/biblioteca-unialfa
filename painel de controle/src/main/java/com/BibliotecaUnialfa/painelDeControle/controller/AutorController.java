package com.BibliotecaUnialfa.painelDeControle.controller;

import com.BibliotecaUnialfa.painelDeControle.model.Autor;
import com.BibliotecaUnialfa.painelDeControle.servicie.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("autor")
public class AutorController {
    @Autowired
    private AutorService service;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de autores");
        model.addAttribute("listaDeAutores", service.listarTodos());
        return "autor/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Autor autor) {
        model.addAttribute("boasVindas", "Cadastro de autores");
        return "autor/formulario";
    }

    @PostMapping("/cadastrar")
    public String salvar(@Valid Autor autor, BindingResult result,Model model) {
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "autor/formulario";
        }
        service.salvar(autor);
        return "redirect:/autor/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("boasVindas", "Cadastro de autores");
        model.addAttribute("autor", service.buscarPorId(id));
        return "autor/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String remover(@PathVariable Long id) {
        service.deletarPorId(id);
        return "redirect:/autor/lista";
    }
}