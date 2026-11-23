package tn.esprit.autoloc.autoloc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import tn.esprit.autoloc.autoloc.domain.StatutReservation;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDTO {
    private Long idReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private StatutReservation statut;
    private Long vehiculeId;
    private Long clientId;
    private ContratDTO contrat;
}
