package tn.esprit.document_autorisee_spring.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idC;
    private String nomC;
    @ManyToMany(mappedBy = "categories" , fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    private Set <Produit> produits;
}
