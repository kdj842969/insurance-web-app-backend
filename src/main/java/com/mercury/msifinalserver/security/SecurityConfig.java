package com.mercury.msifinalserver.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mercury.msifinalserver.security.handler.AccessDeniedHandlerImpl;
import com.mercury.msifinalserver.security.handler.AuthenticationEntryPointImpl;
import com.mercury.msifinalserver.security.handler.AuthenticationFailureHandlerImpl;
import com.mercury.msifinalserver.security.handler.AuthenticationSuccessHandlerImpl;
import com.mercury.msifinalserver.security.handler.LogoutSuccessHandlerImpl;

@EnableWebSecurity // make this class also a bean
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	// WebSecurityConfiguration: abstract class, no abstract function, have to override it and uses
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationEntryPointImpl authenticationEntryPointImpl;
	
	@Autowired
	private AccessDeniedHandlerImpl accessDeniedHandlerImpl;
	
	@Autowired
	private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;
	
	@Autowired
	private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;
	
	@Autowired
	private LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
	    .cors()
	        .and()
	    //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
	    .csrf()
	        .disable()
	    // csrfToken: generate token, which is encoded
	    // if you use http in your browser, javascript cannot decode your csrf token
		.authorizeRequests()
		    .antMatchers("/index.html").permitAll() // 放在authenticated前面，先执行
			//.anyRequest().authenticated() 
		    //.anyRequest().permitAll()
			// authenticated() every request will go to authentication
			// if changing to permitAll(), no need to login
		    .and()
		.exceptionHandling().authenticationEntryPoint(authenticationEntryPointImpl)
		    .and()
		.exceptionHandling().accessDeniedHandler(accessDeniedHandlerImpl)
		    .and()
		.formLogin()	
		    .permitAll() // allow all to login
		    .loginProcessingUrl("/login")
		    .successHandler(authenticationSuccessHandlerImpl)
		    .failureHandler(authenticationFailureHandlerImpl)
		    .usernameParameter("username") // if switch, next give password first
		    .passwordParameter("password")
		.and()
		.logout()
		    .permitAll()
		    .logoutUrl("/logout")
		    .logoutSuccessHandler(logoutSuccessHandlerImpl)
		    .and()
		.rememberMe();
			//.httpBasic(); // terminate function, to start executing all above conditions, 不调最后一个方法，前面的都不会执行
		// builder pattern: and() return h back, h is whoever extends the class
	}
	
	@Bean // put the return object into spring container, as a bean
	// bean can only be added on method
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11); // same algorithm, 11 is the level of encrytion algorithm
	}
	
	@Autowired // @Autowired on function will autowired the parameters
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); 
		// tell which service to call for username and password encryption
		// use userDetailsService to retrieve user in database, use passwordEncoder() to encrypt password
		
	} // 删掉也可以
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // You should only set trusted site here. e.g. http://localhost:4200 means only this site can access.
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}

