package pe.edu.cibertec.t2_daw1_juarez.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    // Autenticacion 2 cosas

    // usuario y el password

    // 1 tu password que algoritmo usaras
    @Bean
    public PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // Authorization
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(autorizar ->
                        autorizar
                                // .requestMatchers("empleados/nueva").denyAll()
                                .requestMatchers("/nosotros", "/signup").permitAll() // Permitir acceso a la ruta /nosotros
                                .requestMatchers("empleado/eliminar", "empleados/nueva", "empleado/edit").hasRole("ADMIN")
                                .requestMatchers("empleados").hasAnyRole("ADMIN", "EMPLEADO")
                                .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
