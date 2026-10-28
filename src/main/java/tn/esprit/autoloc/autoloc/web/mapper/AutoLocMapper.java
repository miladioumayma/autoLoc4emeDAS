package tn.esprit.autoloc.autoloc.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.autoloc.domain.*;
import tn.esprit.autoloc.autoloc.web.dto.*;
import tn.esprit.autoloc.autoloc.repository.*;

@Component
@RequiredArgsConstructor
public class AutoLocMapper {
    private final IAgenceRepository agenceRepository;
    private final IClientRepository clientRepository;
    private final IContratRepository contratRepository;
    private final IVehiculeRepository vehiculeRepository;
    private final IReservationRepository reservationRepository;
    private final IEquipementRepository equipementRepository;

    public AgenceDTO toDTO(Agence e) {
        if (e == null) return null;
        AgenceDTO d = new AgenceDTO();
        d.setIdAgence(e.getIdAgence());
        d.setNom(e.getNom());
        d.setVille(e.getVille());
        d.setAdresse(e.getAdresse());
        d.setTelephone(e.getTelephone());
        return d;
    }

    public Agence toEntity(AgenceDTO d) {
        if (d == null) return null;
        Agence e = new Agence();
        e.setIdAgence(d.getIdAgence());
        e.setNom(d.getNom());
        e.setVille(d.getVille());
        e.setAdresse(d.getAdresse());
        e.setTelephone(d.getTelephone());
        return e;
    }

    public ClientDTO toDTO(Client e) {
        if (e == null) return null;
        ClientDTO d = new ClientDTO();
        d.setIdClient(e.getIdClient());
        d.setNom(e.getNom());
        d.setPrenom(e.getPrenom());
        d.setEmail(e.getEmail());
        d.setTelephone(e.getTelephone());
        d.setNumPermis(e.getNumPermis());
        d.setDateInscription(e.getDateInscription());
        return d;
    }

    public Client toEntity(ClientDTO d) {
        if (d == null) return null;
        Client e = new Client();
        e.setIdClient(d.getIdClient());
        e.setNom(d.getNom());
        e.setPrenom(d.getPrenom());
        e.setEmail(d.getEmail());
        e.setTelephone(d.getTelephone());
        e.setNumPermis(d.getNumPermis());
        e.setDateInscription(d.getDateInscription());
        return e;
    }

    public ContratDTO toDTO(Contrat e) {
        if (e == null) return null;
        ContratDTO d = new ContratDTO();
        d.setIdContrat(e.getIdContrat());
        d.setDateSignature(e.getDateSignature());
        d.setMontantTotal(e.getMontantTotal());
        d.setValide(e.isValide());
        d.setReservationId(e.getReservation() == null ? null : e.getReservation().getIdReservation());
        return d;
    }

    public Contrat toEntity(ContratDTO d) {
        if (d == null) return null;
        Contrat e = new Contrat();
        e.setIdContrat(d.getIdContrat());
        e.setDateSignature(d.getDateSignature());
        e.setMontantTotal(d.getMontantTotal());
        e.setValide(d.isValide());
        if (d.getReservationId() != null) e.setReservation(reservationRepository.findById(d.getReservationId()).orElse(null));
        return e;
    }

    public EmployeDTO toDTO(Employe e) {
        if (e == null) return null;
        EmployeDTO d = new EmployeDTO();
        d.setIdEmploye(e.getIdEmploye());
        d.setNom(e.getNom());
        d.setPrenom(e.getPrenom());
        d.setRole(e.getRole());
        d.setAgenceId(e.getAgence() == null ? null : e.getAgence().getIdAgence());
        return d;
    }

    public Employe toEntity(EmployeDTO d) {
        if (d == null) return null;
        Employe e = new Employe();
        e.setIdEmploye(d.getIdEmploye());
        e.setNom(d.getNom());
        e.setPrenom(d.getPrenom());
        e.setRole(d.getRole());
        if (d.getAgenceId() != null) e.setAgence(agenceRepository.findById(d.getAgenceId()).orElse(null));
        return e;
    }

    public EquipementDTO toDTO(Equipement e) {
        if (e == null) return null;
        EquipementDTO d = new EquipementDTO();
        d.setIdEquipement(e.getIdEquipement());
        d.setLibelle(e.getLibelle());
        return d;
    }

    public Equipement toEntity(EquipementDTO d) {
        if (d == null) return null;
        Equipement e = new Equipement();
        e.setIdEquipement(d.getIdEquipement());
        e.setLibelle(d.getLibelle());
        return e;
    }

    public MaintenanceDTO toDTO(Maintenance e) {
        if (e == null) return null;
        MaintenanceDTO d = new MaintenanceDTO();
        d.setIdMaintenance(e.getIdMaintenance());
        d.setDateDebut(e.getDateDebut());
        d.setDateFin(e.getDateFin());
        d.setDescription(e.getDescription());
        d.setVehiculeId(e.getVehicule() == null ? null : e.getVehicule().getIdVehicule());
        return d;
    }

    public Maintenance toEntity(MaintenanceDTO d) {
        if (d == null) return null;
        Maintenance e = new Maintenance();
        e.setIdMaintenance(d.getIdMaintenance());
        e.setDateDebut(d.getDateDebut());
        e.setDateFin(d.getDateFin());
        e.setDescription(d.getDescription());
        if (d.getVehiculeId() != null) e.setVehicule(vehiculeRepository.findById(d.getVehiculeId()).orElse(null));
        return e;
    }

    public PaiementDTO toDTO(Paiement e) {
        if (e == null) return null;
        PaiementDTO d = new PaiementDTO();
        d.setIdPaiement(e.getIdPaiement());
        d.setMontant(e.getMontant());
        d.setDatePaiement(e.getDatePaiement());
        d.setModePaiement(e.getModePaiement());
        d.setContratId(e.getContrat() == null ? null : e.getContrat().getIdContrat());
        return d;
    }

    public Paiement toEntity(PaiementDTO d) {
        if (d == null) return null;
        Paiement e = new Paiement();
        e.setIdPaiement(d.getIdPaiement());
        e.setMontant(d.getMontant());
        e.setDatePaiement(d.getDatePaiement());
        e.setModePaiement(d.getModePaiement());
        if (d.getContratId() != null) e.setContrat(contratRepository.findById(d.getContratId()).orElse(null));
        return e;
    }

    public ReservationDTO toDTO(Reservation e) {
        if (e == null) return null;
        ReservationDTO d = new ReservationDTO();
        d.setIdReservation(e.getIdReservation());
        d.setDateDebut(e.getDateDebut());
        d.setDateFin(e.getDateFin());
        d.setStatut(e.getStatut());
        d.setVehiculeId(e.getVehicule() == null ? null : e.getVehicule().getIdVehicule());
        d.setClientId(e.getClient() == null ? null : e.getClient().getIdClient());
        return d;
    }

    public Reservation toEntity(ReservationDTO d) {
        if (d == null) return null;
        Reservation e = new Reservation();
        e.setIdReservation(d.getIdReservation());
        e.setDateDebut(d.getDateDebut());
        e.setDateFin(d.getDateFin());
        e.setStatut(d.getStatut());
        if (d.getVehiculeId() != null) e.setVehicule(vehiculeRepository.findById(d.getVehiculeId()).orElse(null));
        if (d.getClientId() != null) e.setClient(clientRepository.findById(d.getClientId()).orElse(null));
        return e;
    }

    public VehiculeDTO toDTO(Vehicule e) {
        if (e == null) return null;
        VehiculeDTO d = new VehiculeDTO();
        d.setIdVehicule(e.getIdVehicule());
        d.setImmatriculation(e.getImmatriculation());
        d.setMarque(e.getMarque());
        d.setModele(e.getModele());
        d.setCategorie(e.getCategorie());
        d.setTarifJournalier(e.getTarifJournalier());
        d.setStatut(e.getStatut());
        d.setAgenceId(e.getAgence() == null ? null : e.getAgence().getIdAgence());
        d.setEquipementIds(e.getEquipements() == null ? java.util.List.of() : e.getEquipements().stream().map(Equipement::getIdEquipement).toList());
        return d;
    }

    public Vehicule toEntity(VehiculeDTO d) {
        if (d == null) return null;
        Vehicule e = new Vehicule();
        e.setIdVehicule(d.getIdVehicule());
        e.setImmatriculation(d.getImmatriculation());
        e.setMarque(d.getMarque());
        e.setModele(d.getModele());
        e.setCategorie(d.getCategorie());
        e.setTarifJournalier(d.getTarifJournalier());
        e.setStatut(d.getStatut());
        if (d.getAgenceId() != null) e.setAgence(agenceRepository.findById(d.getAgenceId()).orElse(null));
        if (d.getEquipementIds() != null) e.setEquipements(equipementRepository.findAllById(d.getEquipementIds()));
        return e;
    }

}
