package org.example.Service;

import org.example.Model.Entidade.DAO.PlantaRepository;
import org.example.Model.Entidade.Planta;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class userService {
    private static PlantaRepository planRep;

    // aqui tem que ter os metodos quer vão ser capazes de realizar as ações do usuario;
    // ele pode fazer, cadastrar uma planta, editar uma planta, buscar uma planta, remover uma planta e calcular a calda nova.

    public void cadPlanta(String nome,
                          float conectracaoMax,
                          float conectracaoMin,
                          String descricao) {
        Planta p1 = new Planta(nome, conectracaoMax, conectracaoMin, descricao);
        planRep.save(p1);
        System.out.println("Planta cadastrada com sucesso!");
    }

    public static void editPlanta() {
    }

    public static List<Planta> listarPlantas() {
        return planRep.findAll();

    }

    public static void buscarPlanta() {
    }

    public static void removerPlanta() {
    }

    public static void calcularCalda(String nomePlanta, String volumeTotal) {
        List<Planta> lista = listarPlantas();
        for (Planta p : lista) {
            if (nomePlanta.equals(p.getNome())) {

            }
        }
    }

    public static void findPalntaById() {
    }


}
