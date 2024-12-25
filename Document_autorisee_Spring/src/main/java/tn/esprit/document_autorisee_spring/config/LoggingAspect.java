package tn.esprit.document_autorisee_spring.config;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.*;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger l = LogManager.getLogger(LoggingAspect.class);
    @Before("execution(* tn.esprit.document_autorisee_spring.Service.ProduitServiceImp.add*(..))")
    public void logMethodeExistBefore(JoinPoint joinPoint) {
        String nomService = joinPoint.getSignature().getName();

        // Afficher le message dans la console
        System.out.println("Bienvenue à l’un des services de l’application Boycott : " + nomService);
        l.info("Before method execution: " + joinPoint.getSignature());
    }
}
