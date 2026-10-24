
package tn.esprit.autoloc.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.domain.Reservation;
import tn.esprit.autoloc.autoloc.repository.IReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    private final IReservationRepository repo;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return repo.findAll();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return repo.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return repo.save(r);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return repo.findById(idReservation).orElse(null);
    }

    @Override
    public void removeReservation(Long idReservation) {
        repo.deleteById(idReservation);
    }

    @Override
    public List<Reservation> addReservations(List<Reservation> reservations) {
        return repo.saveAll(reservations);
    }
}
