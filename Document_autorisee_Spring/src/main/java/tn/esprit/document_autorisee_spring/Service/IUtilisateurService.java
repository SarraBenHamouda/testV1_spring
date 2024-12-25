package tn.esprit.document_autorisee_spring.Service;
import tn.esprit.document_autorisee_spring.Entity.TypeUtilisateur;
import tn.esprit.document_autorisee_spring.Entity.Utilisateur;

import java.util.Date;
import java.util.List;
public interface IUtilisateurService {
    List<Utilisateur> retrieveAllUtilisateurs();
    Utilisateur addUtilisateur(Utilisateur u);
    Utilisateur modifyUtilisateur(Utilisateur u);
    Utilisateur retrieveUtilisateur(Long idu);
    void removeUtilisateur(Long idU);
    public List<Utilisateur> recupererUtilisateursParCriteres(String nomC, Date dateinscr, TypeUtilisateur typeUtilisateur);

}
