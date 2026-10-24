
package tn.esprit.autoloc.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.domain.Employe;
import tn.esprit.autoloc.autoloc.repository.IEmployeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeService implements IEmployeService {

    private final IEmployeRepository repo;

    @Override
    public List<Employe> retrieveAllEmployes() {
        return repo.findAll();
    }

    @Override
    public Employe addEmploye(Employe e) {
        return repo.save(e);
    }

    @Override
    public Employe updateEmploye(Employe e) {
        return repo.save(e);
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {
        return repo.findById(idEmploye).orElse(null);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        repo.deleteById(idEmploye);
    }

    @Override
    public List<Employe> addEmployes(List<Employe> employes) {
        return repo.saveAll(employes);
    }
}
