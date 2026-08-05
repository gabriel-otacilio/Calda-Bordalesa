package org.example.controllers;


import org.example.dto.CaldaRequestDTO;
import org.example.dto.CaldaResponseDTO;
import org.example.dto.PlantaDTO;
import org.example.entity.Planta;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class UserController {
    // como funciona uma controller Spring

    private final UserService user_service;

    // construtor pra injetar a service
    public UserController(UserService userService) {
        this.user_service = userService;
    }

//--------------------------------------------------------


    // funcional
    @PostMapping("/calcularCalda")
    public CaldaResponseDTO calcularCaldaPOST(@RequestBody CaldaRequestDTO request) {
        Planta planta = user_service.findById(request.idPlanta);

        double agua=user_service.calcularCalda(
                request.idPlanta,
                request.volumeTotal,
                request.tipoConcentracao);

        double reagente = Math.round((request.volumeTotal*1000 - agua)/2);
        return new CaldaResponseDTO(agua, reagente, planta);

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
