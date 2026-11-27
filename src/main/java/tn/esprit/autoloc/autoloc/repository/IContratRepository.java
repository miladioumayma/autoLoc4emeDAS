package tn.esprit.autoloc.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.autoloc.domain.Contrat;

import java.time.LocalDate;
import java.util.List;

public interface IContratRepository extends JpaRepository<Contrat, Long> {

    List<Contrat> findByReservation_DateFinBetweenAndValideTrue(
            LocalDate dateDebut,
            LocalDate dateFin
    );
}