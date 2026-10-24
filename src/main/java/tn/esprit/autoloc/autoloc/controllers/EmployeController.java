
package tn.esprit.autoloc.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autoloc.domain.Employe;
import tn.esprit.autoloc.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employe")
@AllArgsConstructor
public class EmployeController {

    private IEmployeService employeService;

    @GetMapping
    public List<Employe> retrieveAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    @GetMapping("/{id}")
    public Employe retrieveEmploye(@PathVariable("id") Long id) {
        return employeService.retrieveEmploye(id);
    }

    @PostMapping
    public Employe addEmploye(@RequestBody Employe e) {
        return employeService.addEmploye(e);
    }

    @PostMapping("/list")
    public List<Employe> addEmployes(@RequestBody List<Employe> employes) {
        return employeService.addEmployes(employes);
    }

    @PutMapping
    public Employe updateEmploye(@RequestBody Employe e) {
        return employeService.updateEmploye(e);
    }

    @DeleteMapping("/{id}")
    public void removeEmploye(@PathVariable("id") Long id) {
        employeService.removeEmploye(id);
    }
}
