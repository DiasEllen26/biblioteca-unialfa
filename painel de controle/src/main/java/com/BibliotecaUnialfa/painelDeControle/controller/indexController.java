package com.BibliotecaUnialfa.painelDeControle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @RequestMapping("/")
    public String iniciar(Model model){
        return "index";
    }
}
