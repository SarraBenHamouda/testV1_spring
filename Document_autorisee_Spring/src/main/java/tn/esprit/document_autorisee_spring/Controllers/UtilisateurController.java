package tn.esprit.document_autorisee_spring.Controllers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.document_autorisee_spring.Entity.TypeUtilisateur;
import tn.esprit.document_autorisee_spring.Entity.Utilisateur;
import tn.esprit.document_autorisee_spring.Service.IUtilisateurService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UtilisateurController {


    IUtilisateurService utilisateurService;

    // http://localhost:8089/document/user/retrieve-all-users
    @GetMapping("/retrieve-all-users")
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurService.retrieveAllUtilisateurs();
    }

    // http://localhost:8089/document/user/retrieve-user/8
    @GetMapping("/retrieve-user/{user-id}")
    public Utilisateur retrieveUtilisateur(@PathVariable("user-id") Long idU) {
        return utilisateurService.retrieveUtilisateur(idU);
    }

    // http://localhost:8089/document/user/retrieve-user
    @PostMapping("/add-utilisateur")
    public Utilisateur addUtilisateur(@RequestBody Utilisateur u) {
        return utilisateurService.addUtilisateur(u);
    }

    // http://localhost:8089/tpfoyer/bloc/remove-bloc/8
    @DeleteMapping("/remove-user/{user-id}")
    public void removeUtilisateur(@PathVariable("user-id") Long idU) {
        utilisateurService.removeUtilisateur(idU);
    }


    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @PutMapping("/modify-utilisateur")
    public Utilisateur modifyUtilisateur(@RequestBody Utilisateur u) {
        return utilisateurService.modifyUtilisateur(u);

    }
    @GetMapping("/recherche")
    public List<Utilisateur> rechercherUtilisateurs(
            @RequestParam String categorie,
            @RequestParam String dateinscri,
            @RequestParam TypeUtilisateur typeUtilisateur) {

        // Conversion directe de la date (String -> Date)
        java.sql.Date dateConverted = java.sql.Date.valueOf(dateinscri); // Format attendu : YYYY-MM-DD

        // Appel direct du service
        return utilisateurService.recupererUtilisateursParCriteres(categorie, dateConverted, typeUtilisateur);
    }

}
