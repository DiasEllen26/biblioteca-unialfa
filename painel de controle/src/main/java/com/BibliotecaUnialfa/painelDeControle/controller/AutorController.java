package com.BibliotecaUnialfa.painelDeControle.controller;

import com.BibliotecaUnialfa.painelDeControle.model.Autor;
import com.BibliotecaUnialfa.painelDeControle.servicie.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("autor")
public class AutorController {
    @Autowired
    private AutorService servicie;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de autores");
        model.addAttribute("listaDeAutores", servicie.listarTodos());
        return "autor/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Autor autor) {
        model.addAttribute("boasVindas", "Cadastro de autores");
        return "autor/formulario";
    }

    @PostMapping("/cadastrar")
    public String salvar(Autor autor) {
        servicie.salvar(autor);
        return "redirect:/autor/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("boasVindas", "Cadastro de autores");
        model.addAttribute("autor", servicie.buscarPorId(id));
        return "autor/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String remover(@PathVariable Long id) {
        servicie.deletarPorId(id);
        return "redirect:/autor/lista";
    }
}