package tn.esprit.autoloc.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.domain.Agence;
import tn.esprit.autoloc.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceService implements IAgenceService{
    AgenceRepository repo;
    @Override
    public List<Agence> retrieveAllAgences() {
         return repo.findAll();
    }

    @Override
    public Agence addAgence(Agence a) {
        return repo.save(a);
    }

    @Override
    public Agence updateAgence(Agence a) {
        return repo.save(a);
    }

    @Override
    public Agence retrieveAgence(Long idAgence) {
        return repo.findById(idAgence).orElse(null);
    }

    @Override
    public void removeAgence(Long idAgence) {
        repo.deleteById(idAgence);
    }

    @Override
    public List<Agence> addAgences(List<Agence> agences) {
        return repo.saveAll(agences);
    }
}
