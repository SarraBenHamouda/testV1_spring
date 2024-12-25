package tn.esprit.document_autorisee_spring.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.document_autorisee_spring.Entity.Categorie;
import tn.esprit.document_autorisee_spring.Entity.Etat;
import tn.esprit.document_autorisee_spring.Entity.Produit;
import tn.esprit.document_autorisee_spring.Entity.Utilisateur;
import tn.esprit.document_autorisee_spring.Repository.CategorieRepository;
import tn.esprit.document_autorisee_spring.Repository.ProduitRepository;
import tn.esprit.document_autorisee_spring.Repository.UtilisateurRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j

public class ProduitServiceImp  implements IProduitService {

    ProduitRepository produitRepository;
    UtilisateurRepository utilisateurRepository;
    CategorieRepository categorieRepository;
    @Override
    public Produit addProduitandCategorie(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public void affecterProdAUser(Long idP, Long idU) {
        Produit produit = produitRepository.findById(idP).get();
        Utilisateur utilisateur = utilisateurRepository.findById(idU).get();
        utilisateur.setEmail(utilisateur.getEmail());
        produitRepository.save(produit);
    }
    @Override
    public boolean chercherProduit(String nomP) {
        return produitRepository.existsByNomP(nomP);
    }

    @Override
    @Scheduled(fixedRate = 40000) // Exécution toutes les 40 secondes
    public void afficherEtMettreAjourProduits() {
        // Récupérer tous les utilisateurs de type "ADMIN"
        List<Utilisateur> admins = utilisateurRepository.findAll();

        for (Utilisateur admin : admins) {
            if ("ADMIN".equals(admin.getTypeU())) {

                List<Produit> produits = (List<Produit>) admin.getProduits();

                // Mettre à jour l'état des produits à "BOYCOTT"
                for (Produit produit : produits) {
                    produit.setEtat(Etat.valueOf("BOYCOTT"));
                    produitRepository.save(produit); // Sauvegarde
                }
            }
        }


        List<Produit> allProduits = produitRepository.findAll();
        allProduits.forEach(System.out::println);
    }
    public void desAffecterCatDeProd(Long idC, Long idP) {
        Produit produit = produitRepository.findById(idP).get();
        Categorie categorie = categorieRepository.findById(idC).get();

        produit.getCategories().remove(categorie);
        produitRepository.save(produit);
    }

}
