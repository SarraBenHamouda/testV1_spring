package tn.esprit.document_autorisee_spring.Service;

import org.springframework.data.repository.query.Param;
import tn.esprit.document_autorisee_spring.Entity.Produit;

import java.util.List;

public interface IProduitService {


    Produit addProduitandCategorie(Produit p);

    void affecterProdAUser(Long idP, Long idU);


    boolean chercherProduit(String nomP);

    void afficherEtMettreAjourProduits();

    void desAffecterCatDeProd(Long idC, Long idP);
}



