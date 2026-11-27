package tn.esprit.autoloc.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.autoloc.domain.Reservation;
import tn.esprit.autoloc.autoloc.domain.StatutReservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByDateDebutAndDateFin(
            LocalDate dateDebut, LocalDate dateFin);
    List<Reservation> findByVehicule_IdVehiculeAndDateDebutLessThanAndDateFinGreaterThanAndStatutNot(
            Long idVehicule,
            LocalDate dateFin,
            LocalDate dateDebut,
            StatutReservation statut
    );
    List<Reservation> findByDateFinLessThanEqualAndStatut(
            LocalDate dateFin,
            StatutReservation statut
    );
}
