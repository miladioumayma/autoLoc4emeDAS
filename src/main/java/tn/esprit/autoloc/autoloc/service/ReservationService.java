
package tn.esprit.autoloc.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.autoloc.domain.Client;
import tn.esprit.autoloc.autoloc.domain.Contrat;
import tn.esprit.autoloc.autoloc.domain.Reservation;
import tn.esprit.autoloc.autoloc.domain.StatutReservation;
import tn.esprit.autoloc.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.autoloc.domain.Vehicule;
import tn.esprit.autoloc.autoloc.repository.IClientRepository;
import tn.esprit.autoloc.autoloc.repository.IReservationRepository;
import tn.esprit.autoloc.autoloc.repository.IVehiculeRepository;
import tn.esprit.autoloc.autoloc.web.dto.ReservationResponseDTO;
import tn.esprit.autoloc.autoloc.web.dto.ReservationWithContratRequestDTO;
import tn.esprit.autoloc.autoloc.web.mapper.AutoLocMapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    private final IReservationRepository repo;
    private final IClientRepository clientRepo;
    private final IVehiculeRepository vehiculeRepo;
    private final AutoLocMapper mapper;

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

    @Override
    @Transactional
    public ReservationResponseDTO affecterReservationAClient(
            Long idReservation, String nom, String prenom) {

        Reservation reservation = repo.findById(idReservation)
                .orElseThrow(() ->
                        new EntityNotFoundException("Réservation introuvable"));

        Client client = clientRepo
                .findByNomIgnoreCaseAndPrenomIgnoreCase(nom, prenom)
                .orElseThrow(() ->
                        new EntityNotFoundException("Client introuvable"));

        reservation.setClient(client);

        Reservation saved = repo.save(reservation);

        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public ReservationResponseDTO creerReservationEtContratAssocie(
            ReservationWithContratRequestDTO requestDTO) {

        if (requestDTO == null ||
                requestDTO.getDateDebut() == null ||
                requestDTO.getDateFin() == null ||
                requestDTO.getDateSignature() == null) {
            throw new IllegalArgumentException("Les dates sont obligatoires");
        }

        if (!requestDTO.getDateFin().isAfter(requestDTO.getDateDebut())) {
            throw new IllegalArgumentException(
                    "La date de fin doit être après la date de début");
        }

        Vehicule vehicule = vehiculeRepo
                .findById(requestDTO.getIdVehicule())
                .orElseThrow(() ->
                        new EntityNotFoundException("Véhicule introuvable"));

        if (vehicule.getStatut() != StatutVehicule.DISPONIBLE) {
            throw new IllegalStateException(
                    "Le véhicule n'est pas disponible");
        }

        List<Reservation> conflits =
                repo.findByVehicule_IdVehiculeAndDateDebutLessThanAndDateFinGreaterThanAndStatutNot(
                        vehicule.getIdVehicule(),
                        requestDTO.getDateFin(),
                        requestDTO.getDateDebut(),
                        StatutReservation.ANNULEE
                );

        if (!conflits.isEmpty()) {
            throw new IllegalStateException(
                    "Le véhicule est déjà réservé pendant cette période");
        }

        Client client = clientRepo
                .findById(requestDTO.getIdClient())
                .orElseThrow(() ->
                        new EntityNotFoundException("Client introuvable"));

        long nombreJours = ChronoUnit.DAYS.between(
                requestDTO.getDateDebut(),
                requestDTO.getDateFin()
        );

        BigDecimal montant = vehicule.getTarifJournalier()
                .multiply(BigDecimal.valueOf(nombreJours))
                .setScale(2, RoundingMode.HALF_UP);

        Reservation reservation = new Reservation();
        reservation.setDateDebut(requestDTO.getDateDebut());
        reservation.setDateFin(requestDTO.getDateFin());
        reservation.setStatut(StatutReservation.EN_ATTENTE);
        reservation.setVehicule(vehicule);
        reservation.setClient(client);

        Contrat contrat = new Contrat();
        contrat.setDateSignature(requestDTO.getDateSignature());
        contrat.setMontantTotal(montant);
        contrat.setValide(true);
        contrat.setReservation(reservation);

        reservation.setContrat(contrat);

        Reservation saved = repo.save(reservation);

        return mapper.toResponseDTO(saved);
    }
}
