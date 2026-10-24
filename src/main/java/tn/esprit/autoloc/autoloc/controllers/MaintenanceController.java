
package tn.esprit.autoloc.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autoloc.domain.Maintenance;
import tn.esprit.autoloc.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
@AllArgsConstructor
public class MaintenanceController {

    private IMaintenanceService maintenanceService;

    @GetMapping
    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    @GetMapping("/{id}")
    public Maintenance retrieveMaintenance(@PathVariable("id") Long id) {
        return maintenanceService.retrieveMaintenance(id);
    }

    @PostMapping
    public Maintenance addMaintenance(@RequestBody Maintenance m) {
        return maintenanceService.addMaintenance(m);
    }

    @PostMapping("/list")
    public List<Maintenance> addMaintenances(
            @RequestBody List<Maintenance> maintenances) {
        return maintenanceService.addMaintenances(maintenances);
    }

    @PutMapping
    public Maintenance updateMaintenance(@RequestBody Maintenance m) {
        return maintenanceService.updateMaintenance(m);
    }

    @DeleteMapping("/{id}")
    public void removeMaintenance(@PathVariable("id") Long id) {
        maintenanceService.removeMaintenance(id);
    }
}
