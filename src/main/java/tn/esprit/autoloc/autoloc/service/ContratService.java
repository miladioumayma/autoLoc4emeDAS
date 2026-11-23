
package tn.esprit.autoloc.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.autoloc.domain.Contrat;
import tn.esprit.autoloc.autoloc.domain.Reservation;
import tn.esprit.autoloc.autoloc.repository.IContratRepository;
import tn.esprit.autoloc.autoloc.repository.IReservationRepository;
import tn.esprit.autoloc.autoloc.web.dto.ContratDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratService implements IContratService {

    private final IContratRepository repo;
    private final IReservationRepository reservationRepo;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return repo.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return repo.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return repo.save(c);
    }

    @Override
    public Contrat retrieveContrat(Long idContrat) {
        return repo.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Long idContrat) {
        repo.deleteById(idContrat);
    }

    @Override
    public List<Contrat> addContrats(List<Contrat> contrats) {
        return repo.saveAll(contrats);
    }

    @Override
    @Transactional
    public ContratDTO affecterContratAReservation(
            LocalDate dateSignature,
            LocalDate dateDebut,
            LocalDate dateFin) {

        if (dateSignature == null || dateDebut == null || dateFin == null) {
            throw new IllegalArgumentException("Les dates sont obligatoires");
        }

        if (!dateFin.isAfter(dateDebut)) {
            throw new IllegalArgumentException(
                    "La date de fin doit être après la date de début");
        }

        List<Reservation> reservations =
                reservationRepo.findByDateDebutAndDateFin(dateDebut, dateFin);

        if (reservations.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune réservation trouvée pour ces dates");
        }

        if (reservations.size() > 1) {
            throw new IllegalStateException(
                    "Plusieurs réservations correspondent à ces dates");
        }

        Reservation reservation = reservations.get(0);

        if (reservation.getContrat() != null) {
            throw new IllegalStateException(
                    "Cette réservation possède déjà un contrat");
        }

        if (reservation.getVehicule() == null) {
            throw new IllegalStateException(
                    "Aucun véhicule associé à cette réservation");
        }

        long nombreJours = ChronoUnit.DAYS.between(dateDebut, dateFin);

        BigDecimal montantTotal = reservation.getVehicule()
                .getTarifJournalier()
                .multiply(BigDecimal.valueOf(nombreJours))
                .setScale(2, RoundingMode.HALF_UP);

        Contrat contrat = new Contrat();
        contrat.setDateSignature(dateSignature);
        contrat.setMontantTotal(montantTotal);
        contrat.setValide(true);
        contrat.setReservation(reservation);

        Contrat savedContrat = repo.save(contrat);

        reservation.setContrat(savedContrat);

        return new ContratDTO(
                savedContrat.getIdContrat(),
                savedContrat.getDateSignature(),
                savedContrat.getMontantTotal(),
                savedContrat.isValide(),
                reservation.getIdReservation()
        );
    }
}
