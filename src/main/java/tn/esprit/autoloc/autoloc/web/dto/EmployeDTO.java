package tn.esprit.autoloc.autoloc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.autoloc.autoloc.domain.RoleEmploye;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDTO {
    private Long idEmploye;
    private String nom;
    private String prenom;
    private RoleEmploye role;
    private Long agenceId;
}
