
package com.BibliotecaUnialfa.painelDeControle.controller;

import com.BibliotecaUnialfa.painelDeControle.model.Editora;
import com.BibliotecaUnialfa.painelDeControle.servicie.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("editora")
public class EditoraController {
    @Autowired
    private EditoraService service;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de editoras");
        model.addAttribute("ListaDeEditoras", service.listarTodos());
        return "editora/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Editora editora) {
        model.addAttribute("boasVindas", "Cadastro de editoras");
        return "editora/formulario";
    }

    @PostMapping("/cadastrar")
    public String salvar(@Valid Editora editora, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "editora/formulario";
        }
        service.salvar(editora);
        return "redirect:/editora/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("boasVindas", "Cadastro de editoras");
        model.addAttribute("editora", service.buscarPorId(id));
        return "editora/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String remover(@PathVariable Long id) {
        service.deletarPorId(id);
        return "redirect:/editora/lista";
    }

}