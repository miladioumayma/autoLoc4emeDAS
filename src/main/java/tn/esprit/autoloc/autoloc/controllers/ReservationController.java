
package tn.esprit.autoloc.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autoloc.domain.Reservation;
import tn.esprit.autoloc.autoloc.service.IReservationService;
import tn.esprit.autoloc.autoloc.web.dto.ReservationResponseDTO;
import tn.esprit.autoloc.autoloc.web.dto.ReservationWithContratRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {

    private IReservationService reservationService;

    @GetMapping
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation retrieveReservation(@PathVariable("id") Long id) {
        return reservationService.retrieveReservation(id);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation r) {
        return reservationService.addReservation(r);
    }

    @PostMapping("/list")
    public List<Reservation> addReservations(
            @RequestBody List<Reservation> reservations) {
        return reservationService.addReservations(reservations);
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation r) {
        return reservationService.updateReservation(r);
    }

    @DeleteMapping("/{id}")
    public void removeReservation(@PathVariable("id") Long id) {
        reservationService.removeReservation(id);
    }

    @PostMapping("/affecter-client/{idReservation}")
    public ReservationResponseDTO affecterReservationAClient(
            @PathVariable Long idReservation,
            @RequestParam String nom,
            @RequestParam String prenom) {

        return reservationService.affecterReservationAClient(
                idReservation, nom, prenom);
    }

    @PostMapping("/creer-avec-contrat")
    public ReservationResponseDTO creerReservationEtContratAssocie(
            @RequestBody ReservationWithContratRequestDTO requestDTO) {

        return reservationService.creerReservationEtContratAssocie(requestDTO);
    }

}
