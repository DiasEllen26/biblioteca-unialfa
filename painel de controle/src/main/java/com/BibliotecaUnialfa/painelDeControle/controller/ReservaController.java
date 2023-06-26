package com.BibliotecaUnialfa.painelDeControle.controller;

import com.BibliotecaUnialfa.painelDeControle.model.Reserva;
import com.BibliotecaUnialfa.painelDeControle.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("reserva")
public class ReservaController {
    @Autowired
    private ReservaService service;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de reservas");
        model.addAttribute("listaDeReservas", service.listarTodos());
        return "reserva/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Reserva reserva) {
        model.addAttribute("boasVindas", "Cadastro de reservas");
        model.addAttribute("listaDeAlunos", service.listarTodosAlunos());
        model.addAttribute("listaDeLivros", service.listarTodosLivros());
        return "reserva/formulario";
    }

    @PostMapping("/cadastrar")
    public String salvar(Reserva reserva) {
        service.salvar(reserva);
        return "redirect:/reserva/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("boasVindas", "Cadastro de reservas");
        model.addAttribute("reserva", service.buscarPorId(id));
        model.addAttribute("listaDeAlunos", service.listarTodosAlunos());
        model.addAttribute("listaDeLivros", service.listarTodosLivros());
        return "reserva/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String remover(@PathVariable Long id) {
        service.deletarPorId(id);
        return "redirect:/reserva/lista";
    }
}