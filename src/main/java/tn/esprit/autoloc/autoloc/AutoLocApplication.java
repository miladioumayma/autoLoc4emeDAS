
package tn.esprit.autoloc.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tn.esprit.autoloc.autoloc.service.*;

@SpringBootApplication
public class AutoLocApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoLocApplication.class, args);
    }

    @Bean
    CommandLineRunner run(
            IClientService clientService,
            IAgenceService agenceService,
            IVehiculeService vehiculeService,
            IEmployeService employeService,
            IContratService contratService,
            IEquipementService equipementService,
            IMaintenanceService maintenanceService,
            IPaiementService paiementService,
            IReservationService reservationService) {

        return args -> {
            System.out.println("Nombre de clients : "
                    + clientService.retrieveAllClients().size());

            System.out.println("Nombre d'agences : "
                    + agenceService.retrieveAllAgences().size());

            System.out.println("Nombre de véhicules : "
                    + vehiculeService.retrieveAllVehicules().size());

            System.out.println("Nombre d'employés : "
                    + employeService.retrieveAllEmployes().size());

            System.out.println("Nombre de contrats : "
                    + contratService.retrieveAllContrats().size());

            System.out.println("Nombre d'équipements : "
                    + equipementService.retrieveAllEquipements().size());

            System.out.println("Nombre de maintenances : "
                    + maintenanceService.retrieveAllMaintenances().size());

            System.out.println("Nombre de paiements : "
                    + paiementService.retrieveAllPaiements().size());

            System.out.println("Nombre de réservations : "
                    + reservationService.retrieveAllReservations().size());
        };
    }
}
