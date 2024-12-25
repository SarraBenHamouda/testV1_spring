package tn.esprit.document_autorisee_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DocumentAutoriseeSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentAutoriseeSpringApplication.class, args);
    }

}