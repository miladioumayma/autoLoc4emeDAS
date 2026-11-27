package tn.esprit.autoloc.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.autoloc.autoloc.domain.*;
import tn.esprit.autoloc.autoloc.repository.IReservationRepository;
import tn.esprit.autoloc.autoloc.repository.IVehiculeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeSchedulerService {

    private final IReservationRepository reservationRepository;
    private final IVehiculeRepository vehiculeRepository;

    @Scheduled(cron = "0 0 1 * * *", zone = "Africa/Tunis")
    @Transactional
    public void libererVehicules() {

        LocalDate dateActuelle = LocalDate.now();

        List<Reservation> reservations =
                reservationRepository
                        .findByDateFinLessThanEqualAndStatut(
                                dateActuelle,
                                StatutReservation.CONFIRMEE
                        );

        for (Reservation reservation : reservations) {

            // Terminer la réservation
            reservation.setStatut(StatutReservation.TERMINEE);

            // Rendre le véhicule disponible
            Vehicule vehicule = reservation.getVehicule();

            if (vehicule != null) {
                vehicule.setStatut(StatutVehicule.DISPONIBLE);
                vehiculeRepository.save(vehicule);
            }

            reservationRepository.save(reservation);
        }

        System.out.println("Traitement des locations terminé !");
    }
}