package org.example.controllers;


import org.example.Model.Entidade.Planta;
import org.example.Service.userService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class userController {
    // como funciona uma controller Spring
    userService user_service;
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/calcularCalda")
    public String calcularCalda() {
        return "calcularCalda";
    }
    @PostMapping("/calcularCalda")
    public void calcularCalda(@RequestParam String nomePlanta, @RequestParam String volumeTotal) {
        user_service.calcularCalda(nomePlanta,volumeTotal);
    }

    @GetMapping("/cadastrar")
    public String cadastro() {
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@RequestParam String nome,
                          @RequestParam String concentracaoMax,
                          @RequestParam String concentracaoMin,
                          @RequestParam String descricao) {
        user_service.cadPlanta(nome, Float.parseFloat(concentracaoMax), Float.parseFloat(concentracaoMin), descricao);
        // ja salva a plantinha
        return "redirect:/";

    }

    @GetMapping("all/plantas")
    public void listarPlantas(Model model) {
        List<Planta> plantas = userService.listarPlantas();
        model.addAttribute("plantas", plantas);
    }


}
