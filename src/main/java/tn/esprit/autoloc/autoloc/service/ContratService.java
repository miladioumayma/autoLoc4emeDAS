
package tn.esprit.autoloc.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.domain.Contrat;
import tn.esprit.autoloc.autoloc.repository.IContratRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratService implements IContratService {

    private final IContratRepository repo;

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
}
