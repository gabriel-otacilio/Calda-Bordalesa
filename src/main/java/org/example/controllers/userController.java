package org.example.controllers;


import org.example.Model.Entidade.Planta;
import org.example.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class userController {
    // como funciona uma controller Spring
    private final UserService user_service;

    // construtor pra injetar a sevrice
    public userController(UserService userService) {
        this.user_service = userService;
    }

    @GetMapping("/")
    public String home() {

        return "home"; // aqui eu redireciono a pagina pra esse template
    }

//--------------------------------------------------------

    @GetMapping("/calcularCalda")
    public String calcularCaldaGET(Model model) {
        model.addAttribute("plantas", user_service.listarPlantas());
        return "calcularCalda";// é o template
    }

    @PostMapping("/calcularCalda")
    public String calcularCaldaPOST(@RequestParam String tipoConcentracao,
                                 @RequestParam double volumeTotal,
                                 @RequestParam int idPlanta,
                                  Model model) {
        Planta planta = user_service.findById(idPlanta);

        double resultAgua=user_service.calcularCalda(idPlanta, volumeTotal, tipoConcentracao);
        double reagente = (volumeTotal*1000 - resultAgua)/2;

        model.addAttribute("agua", resultAgua);
        model.addAttribute("planta", planta);
        model.addAttribute("reagente", reagente);


        return "resultado";// aqui vai falar a receita, como x ml de agua e y de reagente

    }

//-------------------------------------------------------------------

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

//------------------------------------------------------------------------------------

    @GetMapping("/all/plantas")
    public String listarPlantas(Model model) {// esse model quer dizer que eu mostrar um objeto/model na tela.
        List<Planta> plantas = user_service.listarPlantas();
        model.addAttribute("plantas", plantas);// aqui eu passo elas pra dentro da minha pagina, definindo oque é e com qual nome

        return "allPlantas";
    }

//---------------------------------------------------------------------------------------

    @PostMapping("/all/plantas/{id}")
    public String removerPlanta(@PathVariable int id) {
        user_service.removerPlanta(id);
        return "redirect:/all/plantas";
    }
}
