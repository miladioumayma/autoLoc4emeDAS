
package tn.esprit.autoloc.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.domain.Equipement;
import tn.esprit.autoloc.autoloc.repository.IEquipementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipementService implements IEquipementService {

    private final IEquipementRepository repo;

    @Override
    public List<Equipement> retrieveAllEquipements() {
        return repo.findAll();
    }

    @Override
    public Equipement addEquipement(Equipement e) {
        return repo.save(e);
    }

    @Override
    public Equipement updateEquipement(Equipement e) {
        return repo.save(e);
    }

    @Override
    public Equipement retrieveEquipement(Long idEquipement) {
        return repo.findById(idEquipement).orElse(null);
    }

    @Override
    public void removeEquipement(Long idEquipement) {
        repo.deleteById(idEquipement);
    }

    @Override
    public List<Equipement> addEquipements(List<Equipement> equipements) {
        return repo.saveAll(equipements);
    }
}
