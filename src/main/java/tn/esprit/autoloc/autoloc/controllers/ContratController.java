
package tn.esprit.autoloc.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autoloc.domain.Contrat;
import tn.esprit.autoloc.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrat")
@AllArgsConstructor
public class ContratController {

    private IContratService contratService;

    @GetMapping
    public List<Contrat> retrieveAllContrats() {
        return contratService.retrieveAllContrats();
    }

    @GetMapping("/{id}")
    public Contrat retrieveContrat(@PathVariable("id") Long id) {
        return contratService.retrieveContrat(id);
    }

    @PostMapping
    public Contrat addContrat(@RequestBody Contrat c) {
        return contratService.addContrat(c);
    }

    @PostMapping("/list")
    public List<Contrat> addContrats(@RequestBody List<Contrat> contrats) {
        return contratService.addContrats(contrats);
    }

    @PutMapping
    public Contrat updateContrat(@RequestBody Contrat c) {
        return contratService.updateContrat(c);
    }

    @DeleteMapping("/{id}")
    public void removeContrat(@PathVariable("id") Long id) {
        contratService.removeContrat(id);
    }
}
