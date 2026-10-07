package tn.esprit.autoloc.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autoloc.domain.Agence;
import tn.esprit.autoloc.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agence")
@AllArgsConstructor
public class AgenceController {
    private IAgenceService agenceService;

    @GetMapping
    public List<Agence> retrieveAllAgences() { return agenceService.retrieveAllAgences(); }

    @GetMapping("/{id}")
    public Agence retrieveAgence(@PathVariable("id") Long id) { return agenceService.retrieveAgence(id); }

    @PostMapping
    public Agence addAgence(@RequestBody Agence a) { return agenceService.addAgence(a); }

    @PostMapping("/list")
    public List<Agence> addAgences(@RequestBody List<Agence> agences) { return agenceService.addAgences(agences); }

    @PutMapping
    public Agence updateAgence(@RequestBody Agence a) { return agenceService.updateAgence(a); }

    @DeleteMapping("/{id}")
    public void removeAgence(@PathVariable("id") Long id) { agenceService.removeAgence(id); }
}
