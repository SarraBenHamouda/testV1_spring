package tn.esprit.document_autorisee_spring.Repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.document_autorisee_spring.Entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
