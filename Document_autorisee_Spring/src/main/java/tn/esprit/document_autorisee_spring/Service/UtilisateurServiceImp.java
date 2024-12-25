package tn.esprit.document_autorisee_spring.Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.document_autorisee_spring.Entity.TypeUtilisateur;
import tn.esprit.document_autorisee_spring.Entity.Utilisateur;
import tn.esprit.document_autorisee_spring.Repository.UtilisateurRepository;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor

public class UtilisateurServiceImp implements IUtilisateurService {



UtilisateurRepository utilisateurRepository ;

    public List<Utilisateur> retrieveAllUtilisateurs() {
        List<Utilisateur> ul= utilisateurRepository.findAll();
        return ul;
    }
    @Override
    public Utilisateur addUtilisateur(Utilisateur u) {
        return utilisateurRepository.save(u);
    }

    @Override
    public Utilisateur modifyUtilisateur(Utilisateur u) {
        return utilisateurRepository.save(u);
    }

    @Override
    public Utilisateur retrieveUtilisateur(Long idU) {
        return utilisateurRepository.findById(idU).orElse(null);
    }

    @Override
    public void removeUtilisateur(Long idU) {
        utilisateurRepository.deleteById(idU);
    }

    @Override
    public List<Utilisateur> recupererUtilisateursParCriteres(String nomC, Date dateinscr, TypeUtilisateur typeUtilisateur){
        return utilisateurRepository.recupererUtilisateursParCriteres(nomC, dateinscr, typeUtilisateur);

    }

}