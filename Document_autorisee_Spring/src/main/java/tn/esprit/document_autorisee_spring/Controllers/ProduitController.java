package tn.esprit.document_autorisee_spring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.document_autorisee_spring.Entity.Produit;
import tn.esprit.document_autorisee_spring.Service.IProduitService;

@RestController
@AllArgsConstructor
@RequestMapping("/produit")
public class ProduitController {

    private final IProduitService produitService;

    @PostMapping("/addProduitandCategorie")
    public Produit addProduitandCategorie(@RequestBody Produit p) {
        return produitService.addProduitandCategorie(p);
    }

    @PostMapping("/affecterProdAUser/{produit-idP}/{utilisateur-idU}")
    public void affecterProdAUser(@PathVariable("produit-idP") Long idP,
                                  @PathVariable("utilisateur-idU") Long idU) {
        produitService.affecterProdAUser(idP, idU);
    }

    @GetMapping("/chercher")
    public boolean chercherProduit(@RequestParam String nomP) {
        return produitService.chercherProduit(nomP);
    }

    @GetMapping("/update-admin-products")
    public void afficherEtMettreAjourProduits() {
        produitService.afficherEtMettreAjourProduits();

    }
    @PostMapping("/desaffecter-categories")
    public void desAffecterCatDeProd(@RequestBody Long idC,
                                     @RequestParam Long idP) {
        produitService.desAffecterCatDeProd(idC, idP);
    }
}
