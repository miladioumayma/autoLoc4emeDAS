package tn.esprit.autoloc.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.autoloc.autoloc.service.IAgenceService;
import tn.esprit.autoloc.autoloc.service.IClientService;

@SpringBootApplication
public class AutoLocApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoLocApplication.class, args);
    }
    @Bean
    CommandLineRunner run(IClientService clientService, IAgenceService agenceService) {
        return args -> {
            System.out.println("Nombre de clients : " + clientService.retrieveAllClients().size());
            System.out.println("Nombre d'agences : " + agenceService.retrieveAllAgences().size());
        };
    }
}
