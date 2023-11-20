package pete.eremeykin.client.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests((requests) -> requests.anyRequest().authenticated())
                .oauth2Client(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> userDetails = Stream.of(
                        Map.entry("alice", "alice123"),
                        Map.entry("bob", "bob321"))
                .map((user) ->
                        User.builder()
                                .username(user.getKey())
                                .password(passwordEncoder().encode(user.getValue()))
                                .roles("USER")
                                .build()).toList();
        return new InMemoryUserDetailsManager(userDetails);
    }
}