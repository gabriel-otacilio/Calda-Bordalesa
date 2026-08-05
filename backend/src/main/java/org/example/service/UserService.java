package org.example.service;

import jakarta.transaction.Transactional;
import org.example.repository.PlantaRepository;
import org.example.entity.Planta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final PlantaRepository planRep;

    public UserService(PlantaRepository planRep) {
        this.planRep = planRep;
    }

    // aqui tem que ter os metodos quer vão ser capazes de realizar as ações do usuario;
    // ele pode fazer, cadastrar uma planta, editar uma planta, buscar uma planta, remover uma planta e calcular a calda nova.

    @Transactional
    public Planta cadPlanta(String nome,
                            float concentracaoMax,
                            float concentracaoMin,
                            String descricao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("nome da planta nao pode ser vazio");
        }
        if (concentracaoMax < concentracaoMin || concentracaoMax < 0 || concentracaoMin < 0) {
            throw new IllegalArgumentException("concentrações nao podem ser negativas e invalidas ou a maxima deve ser menor que a minima");
        }
        Planta p1 = new Planta(nome, concentracaoMax, concentracaoMin, descricao);
        planRep.save(p1);
        System.out.println("Planta cadastrada com sucesso!");
        return p1;
    }

    @Transactional
    public void editPlanta() {
    }

    public List<Planta> listarPlantas() {
        return planRep.findAll();
    }


    public Planta findById(int id) {
        return planRep.findById(id).orElse(null);
    }


    @Transactional
    public void removerPlanta(int id) {
        planRep.removeById(id);
    }

    public double calcularCalda(int id, double volumeTotal, String tipoConcentracao) {
        Planta planta = findById(id);
        double concentracao;
        if (tipoConcentracao.equals("MAX")) {
            concentracao = planta.getConcentracaoMax();
        } else {
            concentracao = planta.getConcentracaoMin();
        }

        return Math.round(((concentracao * 1000 * 2) - volumeTotal * 1000) * -1); // em ml


    }
}
