package systems.nolasco.portafolio.resourceserverdemo.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
// @Profile("dev")
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/api/v1/products/public").permitAll()
                .requestMatchers("/api/v1/products/private").authenticated()
                .requestMatchers("/api/v1/products/private-scoped").hasAuthority("SCOPE_read:messages")
                .and().cors(withDefaults())
                .oauth2ResourceServer(server -> server.jwt());
        return http.build();
    }
}