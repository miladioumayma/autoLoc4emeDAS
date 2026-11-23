package tn.esprit.autoloc.autoloc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationWithContratRequestDTO {
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalDate dateSignature;
    private Long idVehicule;
    private Long idClient;
}
