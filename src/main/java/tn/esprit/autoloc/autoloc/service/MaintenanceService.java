
package tn.esprit.autoloc.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.domain.Maintenance;
import tn.esprit.autoloc.autoloc.repository.IMaintenanceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceService implements IMaintenanceService {

    private final IMaintenanceRepository repo;

    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        return repo.findAll();
    }

    @Override
    public Maintenance addMaintenance(Maintenance m) {
        return repo.save(m);
    }

    @Override
    public Maintenance updateMaintenance(Maintenance m) {
        return repo.save(m);
    }

    @Override
    public Maintenance retrieveMaintenance(Long idMaintenance) {
        return repo.findById(idMaintenance).orElse(null);
    }

    @Override
    public void removeMaintenance(Long idMaintenance) {
        repo.deleteById(idMaintenance);
    }

    @Override
    public List<Maintenance> addMaintenances(List<Maintenance> maintenances) {
        return repo.saveAll(maintenances);
    }
}
