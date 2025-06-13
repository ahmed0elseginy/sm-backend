package zag.library.security.core.config;

import io.jsonwebtoken.security.Keys;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import zag.library.security.core.filter.AuthenticationRESTFilter;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@ImportAutoConfiguration(SecurityAutoConfiguration.class)
public class SecurityConfiguration {
    private static final String AUTH_PUBLIC_PATH = "/auth/**";
    private static final String SWAGGER_DOCS_JSON_PATH = "/v3/**";
    private static final String SWAGGER_UI_HTML_PATH = "/swagger-ui.html";
    private static final String SWAGGER_DOCS_HTML_PATH = "/swagger-ui/**";
    private static final String SWAGGER_FAVICON_PATH = "/favicon.ico";
    private static final String ACTUATOR_PATH = "/actuator/**";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationRESTFilter jwtFilter) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(request -> {
                    request.requestMatchers(AUTH_PUBLIC_PATH, SWAGGER_DOCS_JSON_PATH, SWAGGER_DOCS_HTML_PATH,
                                    SWAGGER_UI_HTML_PATH, SWAGGER_FAVICON_PATH, ACTUATOR_PATH).permitAll()
                            .anyRequest().authenticated();
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public SecretKey jwtTokenSecretKey() throws Exception {
//        final String HASHING_ALGORITHM = "HmacSHA256";
//        KeyGenerator keyGen = KeyGenerator.getInstance(HASHING_ALGORITHM);
//        SecretKey sk = keyGen.generateKey();
//        return Keys.hmacShaKeyFor(sk.getEncoded());
        String salt = "asdasdaszxvxcvxbasfdasdniu12h4o123890123ueabs98dh8b128ey123";
        return Keys.hmacShaKeyFor(salt.getBytes());
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
