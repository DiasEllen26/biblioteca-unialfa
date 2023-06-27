package com.BibliotecaUnialfa.painelDeControle.controller;

import com.BibliotecaUnialfa.painelDeControle.model.Reserva;
import com.BibliotecaUnialfa.painelDeControle.service.ReservaService;
import com.BibliotecaUnialfa.painelDeControle.service.AlunoService;
import com.BibliotecaUnialfa.painelDeControle.servicie.LivroServicie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("reserva")
public class ReservaController {
    @Autowired
    private ReservaService service;
    @Autowired
    private AlunoService  serviceAluno;
    @Autowired
    private LivroServicie serviceLivro;


    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de reservas");
        model.addAttribute("listaDeReservas", service.listarTodos());
        return "reserva/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Reserva reserva) {
        model.addAttribute("boasVindas", "Cadastro de reservas");
        model.addAttribute("listaDeAlunos", serviceAluno.listarTodos());
        model.addAttribute("listaDeLivros", serviceLivro.listarTodos());
        return "reserva/formulario";
    }

    @PostMapping("/cadastrar")
    public String salvar(@Valid Reserva reserva, BindingResult result,Model model) {
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("listaDeAlunos", serviceAluno.listarTodos());
            model.addAttribute("listaDeLivros", serviceLivro.listarTodos());
            return "reserva/formulario";
        }
        service.salvar(reserva);
        return "redirect:/reserva/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("boasVindas", "Cadastro de reservas");
        model.addAttribute("reserva", service.buscarPorId(id));
        model.addAttribute("listaDeAlunos", serviceAluno.listarTodos());
        model.addAttribute("listaDeLivros", serviceLivro.listarTodos());
        return "reserva/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String remover(@PathVariable Long id) {
        service.deletarPorId(id);
        return "redirect:/reserva/lista";
    }
}