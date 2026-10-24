
package tn.esprit.autoloc.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autoloc.domain.Equipement;
import tn.esprit.autoloc.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipement")
@AllArgsConstructor
public class EquipementController {

    private IEquipementService equipementService;

    @GetMapping
    public List<Equipement> retrieveAllEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    @GetMapping("/{id}")
    public Equipement retrieveEquipement(@PathVariable("id") Long id) {
        return equipementService.retrieveEquipement(id);
    }

    @PostMapping
    public Equipement addEquipement(@RequestBody Equipement e) {
        return equipementService.addEquipement(e);
    }

    @PostMapping("/list")
    public List<Equipement> addEquipements(
            @RequestBody List<Equipement> equipements) {
        return equipementService.addEquipements(equipements);
    }

    @PutMapping
    public Equipement updateEquipement(@RequestBody Equipement e) {
        return equipementService.updateEquipement(e);
    }

    @DeleteMapping("/{id}")
    public void removeEquipement(@PathVariable("id") Long id) {
        equipementService.removeEquipement(id);
    }
}
