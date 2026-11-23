package tn.esprit.autoloc.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.autoloc.domain.Client;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByNomIgnoreCaseAndPrenomIgnoreCase(
            String nom, String prenom);
}
