
package tn.esprit.autoloc.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autoloc.domain.Vehicule;
import tn.esprit.autoloc.autoloc.service.IVehiculeService;
import tn.esprit.autoloc.autoloc.web.dto.VehiculeDTO;

import java.util.List;

@RestController
@RequestMapping("/vehicule")
@AllArgsConstructor
public class VehiculeController {

    private IVehiculeService vehiculeService;

    @GetMapping
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @GetMapping("/{id}")
    public Vehicule retrieveVehicule(@PathVariable("id") Long id) {
        return vehiculeService.retrieveVehicule(id);
    }

    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule v) {
        return vehiculeService.addVehicule(v);
    }

    @PostMapping("/list")
    public List<Vehicule> addVehicules(@RequestBody List<Vehicule> vehicules) {
        return vehiculeService.addVehicules(vehicules);
    }

    @PutMapping
    public Vehicule updateVehicule(@RequestBody Vehicule v) {
        return vehiculeService.updateVehicule(v);
    }

    @DeleteMapping("/{id}")
    public void removeVehicule(@PathVariable("id") Long id) {
        vehiculeService.removeVehicule(id);
    }

    @PutMapping("/{idVehicule}/equipement/{idEquipement}")
    public VehiculeDTO affecterVehiculeAEquipement(
            @PathVariable Long idVehicule,
            @PathVariable Long idEquipement) {

        return vehiculeService.affecterVehiculeAEquipement(
                idVehicule, idEquipement);
    }

    @PostMapping("/maintenance")
    public VehiculeDTO affecterMaintenanceAvehicule(
            @RequestParam String description,
            @RequestParam String immatriculation) {

        return vehiculeService.affecterMaintenanceAvehicule(
                description, immatriculation);
    }

}
