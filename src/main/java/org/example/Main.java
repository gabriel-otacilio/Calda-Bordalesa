package org.example;

import org.example.Model.Entidade.DAO.UserRepository;
import org.example.Model.Entidade.Planta;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.example.Model.Entidade.DAO.PlantaRepository;
import org.example.Model.Entidade.User;

// defini o projeto como um projeto Spring Boot
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);// liga o Spring@Bean
    }

}