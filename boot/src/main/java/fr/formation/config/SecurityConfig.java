// package fr.formation.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
// 	@Bean
// 	public PasswordEncoder passwordEncoder() {
// 		System.out.println(new BCryptPasswordEncoder().encode("123456"));
// 		return new BCryptPasswordEncoder();

// 	}


// 	@Override
// 	protected void configure(HttpSecurity http) throws Exception {

// 		http.authorizeRequests()
// 			.antMatchers("/assets/**").permitAll()
// 			.antMatchers("/**").permitAll();

// 		http.formLogin()
// 			.loginPage("/se-connecter") 
// 			.loginProcessingUrl("/perform_login")
// 			.defaultSuccessUrl("/home", false) 
// 			.failureUrl("/se-connecter?erreur=true") /
// 			.permitAll();
		
// 		http.csrf().disable(); //
// 	}
// }