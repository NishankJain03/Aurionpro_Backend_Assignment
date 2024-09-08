package com.aurionpro.bankapp.config;

import java.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.aurionpro.bankapp.security.JwtAuthenticationEntryPoint;
import com.aurionpro.bankapp.security.JwtAuthenticationFilter;
import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@EnableMethodSecurity
@Configuration
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Bean
	static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(csrf -> csrf.disable()).cors(withDefaults());
		httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(STATELESS));
		httpSecurity.authorizeHttpRequests(request -> request.requestMatchers("/bankapplication/register").permitAll());
		httpSecurity.authorizeHttpRequests(request -> request.requestMatchers("/bankapplication/login").permitAll());
		httpSecurity.authorizeHttpRequests(
				request -> request.requestMatchers("/bankapplication/addCustomerDetails").permitAll());
		httpSecurity.authorizeHttpRequests(request -> request.requestMatchers("/bankapplication/add/roleforUser").permitAll());
		httpSecurity.authorizeHttpRequests(request -> request.requestMatchers("/bankapplication/generate").permitAll());
		httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		return httpSecurity.build();
	}

}
