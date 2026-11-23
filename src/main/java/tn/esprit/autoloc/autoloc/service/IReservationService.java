
package tn.esprit.autoloc.autoloc.service;

import tn.esprit.autoloc.autoloc.domain.Reservation;
import java.util.List;
import tn.esprit.autoloc.autoloc.web.dto.ReservationResponseDTO;
import tn.esprit.autoloc.autoloc.web.dto.ReservationWithContratRequestDTO;
public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation(Reservation r);
    Reservation updateReservation(Reservation r);
    Reservation retrieveReservation(Long idReservation);
    void removeReservation(Long idReservation);
    List<Reservation> addReservations(List<Reservation> reservations);
    ReservationResponseDTO affecterReservationAClient(
            Long idReservation, String nom, String prenom);

    ReservationResponseDTO creerReservationEtContratAssocie(
            ReservationWithContratRequestDTO requestDTO);
}
