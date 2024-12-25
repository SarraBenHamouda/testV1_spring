package tn.esprit.document_autorisee_spring.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.document_autorisee_spring.Entity.Produit;

import java.util.List;

@Repository

public interface ProduitRepository extends JpaRepository<Produit, Long> {
   boolean existsByNomP(String nomP);
}


