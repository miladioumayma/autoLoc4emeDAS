
package tn.esprit.autoloc.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.autoloc.domain.Equipement;
import tn.esprit.autoloc.autoloc.domain.Maintenance;
import tn.esprit.autoloc.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.autoloc.domain.Vehicule;
import tn.esprit.autoloc.autoloc.repository.IVehiculeRepository;
import tn.esprit.autoloc.autoloc.repository.IEquipementRepository;
import tn.esprit.autoloc.autoloc.repository.IMaintenanceRepository;
import tn.esprit.autoloc.autoloc.web.dto.VehiculeDTO;
import tn.esprit.autoloc.autoloc.web.mapper.AutoLocMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VehiculeService implements IVehiculeService {

    private final IVehiculeRepository repo;
    private final IEquipementRepository equipementRepo;
    private final IMaintenanceRepository maintenanceRepo;
    private final AutoLocMapper mapper;

    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return repo.findAll();
    }

    @Override
    public Vehicule addVehicule(Vehicule v) {
        return repo.save(v);
    }

    @Override
    public Vehicule updateVehicule(Vehicule v) {
        return repo.save(v);
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return repo.findById(idVehicule).orElse(null);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        repo.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> addVehicules(List<Vehicule> vehicules) {
        return repo.saveAll(vehicules);
    }

    @Override
    @Transactional
    public VehiculeDTO affecterVehiculeAEquipement(
            Long idVehicule, Long idEquipement) {

        Vehicule vehicule = repo.findById(idVehicule)
                .orElseThrow(() ->
                        new EntityNotFoundException("Véhicule introuvable"));

        Equipement equipement = equipementRepo.findById(idEquipement)
                .orElseThrow(() ->
                        new EntityNotFoundException("Equipement introuvable"));

        if (vehicule.getEquipements() == null) {
            vehicule.setEquipements(new ArrayList<>());
        }

        if (!vehicule.getEquipements().contains(equipement)) {
            vehicule.getEquipements().add(equipement);
        }

        Vehicule saved = repo.save(vehicule);

        return mapper.toDTO(saved);
    }

    @Override
    @Transactional
    public VehiculeDTO affecterMaintenanceAvehicule(
            String description, String immatriculation) {

        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException(
                    "La description est obligatoire");
        }

        Vehicule vehicule = repo.findByImmatriculation(immatriculation)
                .orElseThrow(() ->
                        new EntityNotFoundException("Véhicule introuvable"));

        LocalDate aujourdHui = LocalDate.now();

        Maintenance maintenance = new Maintenance();
        maintenance.setDescription(description);
        maintenance.setDateDebut(aujourdHui);
        maintenance.setDateFin(aujourdHui);
        maintenance.setVehicule(vehicule);

        maintenanceRepo.save(maintenance);

        if (vehicule.getMaintenances() == null) {
            vehicule.setMaintenances(new ArrayList<>());
        }

        vehicule.getMaintenances().add(maintenance);
        vehicule.setStatut(StatutVehicule.MAINTENANCE);

        Vehicule saved = repo.save(vehicule);

        return mapper.toDTO(saved);
    }
}
