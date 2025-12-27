package org.example.Service;

import org.example.Model.Entidade.DAO.PlantaRepository;
import org.example.Model.Entidade.Planta;
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

    public void editPlanta() {
    }

    public List<Planta> listarPlantas() {
        return planRep.findAll();
    }

    public Planta buscarPlantaByname(String name) {
        return planRep.findByNome(name);
    }

    public void removerPlanta() {

    }

    public void calcularCalda(String nomePlanta, String volumeTotal) {
        Planta planta = buscarPlantaByname(nomePlanta);
        if (planta != null) {
            float volume = Float.parseFloat(volumeTotal);
            // todo implementar metodo de calculo aqui
        }
    }
}
