package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Config;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t02.n01.Model.Repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final PlayerRepository playerRepository;
    @Bean
    public UserDetailsService userDetailsService(){
        return userEmail -> playerRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
