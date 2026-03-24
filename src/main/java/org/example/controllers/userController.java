package org.example.controllers;


import org.example.DTO.PlantaDTO;
import org.example.Model.Entidade.Planta;
import org.example.Service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class userController {
    // como funciona uma controller Spring
    private final UserService user_service;

    // construtor pra injetar a sevrice
    public userController(UserService userService) {
        this.user_service = userService;
    }

//--------------------------------------------------------



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


        return "resultado";

    }

//-------------------------------------------------------------------
    // cadastra uma planta
    @PostMapping("/cadPlanta")
    public String cadastrar(@RequestBody PlantaDTO planta) {
        user_service.cadPlanta(planta.nome, planta.concentracaoMax, planta.concentracaoMin, planta.descricao);
        return "planta cadastrada com sucesso!";
    }

//------------------------------------------------------------------------------------
    // retornando uma lista
    @GetMapping("/allPlantas")
    public List<Planta> listarPlantas() {// esse model quer dizer que eu mostrar um objeto/model na tela
        return user_service.listarPlantas();// o spring vai transformar automaticamente a lista em json
    }

//---------------------------------------------------------------------------------------

    @PostMapping("/allPlantas/{id}")
    public String removerPlanta(@PathVariable int id) {
        user_service.removerPlanta(id);
        return "redirect:/all/plantas";
    }
}
