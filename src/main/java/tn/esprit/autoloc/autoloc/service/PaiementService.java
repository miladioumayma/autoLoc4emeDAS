
package tn.esprit.autoloc.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.domain.Paiement;
import tn.esprit.autoloc.autoloc.repository.IPaiementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementService implements IPaiementService {

    private final IPaiementRepository repo;

    @Override
    public List<Paiement> retrieveAllPaiements() {
        return repo.findAll();
    }

    @Override
    public Paiement addPaiement(Paiement p) {
        return repo.save(p);
    }

    @Override
    public Paiement updatePaiement(Paiement p) {
        return repo.save(p);
    }

    @Override
    public Paiement retrievePaiement(Long idPaiement) {
        return repo.findById(idPaiement).orElse(null);
    }

    @Override
    public void removePaiement(Long idPaiement) {
        repo.deleteById(idPaiement);
    }

    @Override
    public List<Paiement> addPaiements(List<Paiement> paiements) {
        return repo.saveAll(paiements);
    }
}
