package codes.aliahmad.springauth.user.security;


import codes.aliahmad.springauth.user.security.filter.JwtFilter;
import codes.aliahmad.springauth.user.security.middleware.AuthEntryPoint;
import codes.aliahmad.springauth.user.security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class WebSecurityConfig
{
  private final UserDetailsServiceImpl userDetailsService;
  private final AuthEntryPoint unauthorizedHandler;
  private final JwtFilter authenticationJwtTokenFilter;

  @Bean
  public AuthenticationProvider authenticationProvider()
  {
    DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();

    daoAuthProvider.setUserDetailsService(userDetailsService);
    daoAuthProvider.setPasswordEncoder(passwordEncoder());

    return daoAuthProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception
  {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder()
  {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
  {
    http.csrf(AbstractHttpConfigurer::disable)
            .cors(AbstractHttpConfigurer::disable)
            .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth ->
                    auth.requestMatchers("/api/v1/auth/**").permitAll()
                            .requestMatchers(HttpMethod.OPTIONS).permitAll()
                            .requestMatchers("/documentation", "/swagger-ui/**", "v3/api-docs/**").permitAll()
                            .anyRequest().authenticated()
            );

    http.authenticationProvider(authenticationProvider());

    http.addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

}
