
package tn.esprit.autoloc.autoloc.service;

import tn.esprit.autoloc.autoloc.domain.Equipement;
import java.util.List;

public interface IEquipementService {
    List<Equipement> retrieveAllEquipements();
    Equipement addEquipement(Equipement e);
    Equipement updateEquipement(Equipement e);
    Equipement retrieveEquipement(Long idEquipement);
    void removeEquipement(Long idEquipement);
    List<Equipement> addEquipements(List<Equipement> equipements);
}
