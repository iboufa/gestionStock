package com.gestion.stock.config;
import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Retourner l'utilisateur actuel (par exemple, depuis le contexte de sécurité)
        return Optional.of("System");  // À modifier selon votre gestion utilisateur (ex. : depuis Spring Security)
    }
}
