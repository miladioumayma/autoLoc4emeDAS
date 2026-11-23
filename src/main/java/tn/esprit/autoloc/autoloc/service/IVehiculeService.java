package tn.esprit.autoloc.autoloc.service;

import tn.esprit.autoloc.autoloc.domain.Vehicule;

import java.util.List;
import tn.esprit.autoloc.autoloc.web.dto.VehiculeDTO;
public interface IVehiculeService {
    List<Vehicule> retrieveAllVehicules();
    Vehicule addVehicule(Vehicule v);
    Vehicule updateVehicule(Vehicule v);
    Vehicule retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    List<Vehicule> addVehicules(List<Vehicule> vehicules);
    VehiculeDTO affecterVehiculeAEquipement(
            Long idVehicule, Long idEquipement);

    VehiculeDTO affecterMaintenanceAvehicule(
            String description, String immatriculation);
}
