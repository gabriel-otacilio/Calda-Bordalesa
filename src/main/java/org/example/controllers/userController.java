package org.example.controllers;


import org.example.DTO.CaldaRequestDTO;
import org.example.DTO.CaldaResponseDTO;
import org.example.DTO.PlantaDTO;
import org.example.Model.Entidade.Planta;
import org.example.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:5173")
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


    // funcional
    @PostMapping("/calcularCalda")
    public CaldaResponseDTO calcularCaldaPOST(@RequestBody CaldaRequestDTO request) {
        Planta planta = user_service.findById(request.idPlanta);

        double resultAgua=user_service.calcularCalda(
                request.idPlanta,
                request.volumeTotal,
                request.tipoConcentracao);

        double reagente = (request.volumeTotal*1000 - resultAgua)/2;
        return new CaldaResponseDTO(resultAgua, reagente, planta);

    }

//-------------------------------------------------------------------
    // cadastra uma planta
    //funcional
    @PostMapping("/cadPlanta")
    public String cadastrar(@RequestBody PlantaDTO planta) {
        user_service.cadPlanta(planta.nome, planta.concentracaoMax, planta.concentracaoMin, planta.descricao);
        return "planta cadastrada com sucesso!";
    }

//------------------------------------------------------------------------------------
    // retornando uma lista
    // funcional
    @GetMapping("/allPlantas")
    public List<Planta> listarPlantas() {
        return user_service.listarPlantas();// o spring vai transformar automaticamente a lista em json
    }

//---------------------------------------------------------------------------------------
    // funcional
    @DeleteMapping("/allPlantas/{id}")
    public String removerPlanta(@PathVariable int id) {
        user_service.removerPlanta(id);
        return "planta de id: " + id + " removida com sucesso!";

    }
}
