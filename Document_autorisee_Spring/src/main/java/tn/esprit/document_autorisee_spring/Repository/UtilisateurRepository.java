package tn.esprit.document_autorisee_spring.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.document_autorisee_spring.Entity.TypeUtilisateur;
import tn.esprit.document_autorisee_spring.Entity.Utilisateur;

import java.util.Date;
import java.util.List;

@Repository

public interface UtilisateurRepository  extends JpaRepository <Utilisateur, Long> {

    @Query("SELECT DISTINCT u FROM Utilisateur u " +
            "JOIN u.produits p " +
            "JOIN p.categories c " +
            "WHERE c.nomC = :nomC " +
            "AND u.dateinscri > :dateinscri " +
            "AND u.typeU = :typeUtilisateur")
    List<Utilisateur> recupererUtilisateursParCriteres(@Param("nomC") String nomC,
                                                       @Param("dateinscri") Date dateinscri,
                                                       @Param("typeUtilisateur") TypeUtilisateur typeUtilisateur);
}

