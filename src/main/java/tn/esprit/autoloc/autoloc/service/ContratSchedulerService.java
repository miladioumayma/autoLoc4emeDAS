package tn.esprit.autoloc.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.repository.IContratRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ContratSchedulerService {

    private final IContratRepository contratRepository;

    @Scheduled(cron = "0 0 7 * * MON-FRI", zone = "Africa/Tunis")
    public void verifierContrats() {

        LocalDate dateActuelle = LocalDate.now();
        LocalDate dateLimite = dateActuelle.plusDays(2);

        System.out.println("Vérification des contrats...");

        contratRepository
                .findByReservation_DateFinBetweenAndValideTrue(
                        dateActuelle, dateLimite
                )
                .forEach(contrat ->
                        System.out.println(
                                "Contrat arrivant à échéance : "
                                        + contrat.getIdContrat()
                        )
                );
    }
}