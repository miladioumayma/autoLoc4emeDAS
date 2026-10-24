
package tn.esprit.autoloc.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autoloc.domain.Paiement;
import tn.esprit.autoloc.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiement")
@AllArgsConstructor
public class PaiementController {

    private IPaiementService paiementService;

    @GetMapping
    public List<Paiement> retrieveAllPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    @GetMapping("/{id}")
    public Paiement retrievePaiement(@PathVariable("id") Long id) {
        return paiementService.retrievePaiement(id);
    }

    @PostMapping
    public Paiement addPaiement(@RequestBody Paiement p) {
        return paiementService.addPaiement(p);
    }

    @PostMapping("/list")
    public List<Paiement> addPaiements(
            @RequestBody List<Paiement> paiements) {
        return paiementService.addPaiements(paiements);
    }

    @PutMapping
    public Paiement updatePaiement(@RequestBody Paiement p) {
        return paiementService.updatePaiement(p);
    }

    @DeleteMapping("/{id}")
    public void removePaiement(@PathVariable("id") Long id) {
        paiementService.removePaiement(id);
    }
}
