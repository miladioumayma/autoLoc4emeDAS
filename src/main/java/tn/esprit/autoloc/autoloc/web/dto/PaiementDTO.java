package tn.esprit.autoloc.autoloc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import tn.esprit.autoloc.autoloc.domain.ModePaiement;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaiementDTO {
    private Long idPaiement;
    private BigDecimal montant;
    private LocalDate datePaiement;
    private ModePaiement modePaiement;
    private Long contratId;
}

