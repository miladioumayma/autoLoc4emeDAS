
package tn.esprit.autoloc.autoloc.service;

import tn.esprit.autoloc.autoloc.domain.Contrat;
import java.util.List;
import tn.esprit.autoloc.autoloc.web.dto.ContratDTO;
import java.time.LocalDate;

public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat addContrat(Contrat c);
    Contrat updateContrat(Contrat c);
    Contrat retrieveContrat(Long idContrat);
    void removeContrat(Long idContrat);
    List<Contrat> addContrats(List<Contrat> contrats);
    ContratDTO affecterContratAReservation(
            LocalDate dateSignature,
            LocalDate dateDebut,
            LocalDate dateFin);
}
