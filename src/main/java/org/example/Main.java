package org.example;

import org.example.Model.Entidade.Planta;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.example.Model.Entidade.DAO.PlantaRepository;

// defini o projeto como um projeto Spring Boot
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main .class,args);// liga o Spring@Bean
    }

    @Bean
    CommandLineRunner run(PlantaRepository plantaRep) {
        return args -> {
            Planta planta = new Planta(0, "abacate", 2.56F, 1.25F, "é verde");
            plantaRep.save(planta); // AGORA SIM salva no banco!
            System.out.println("✅ Planta salva no banco de dados!");
        };
    }
    // oque isso faz ?

}