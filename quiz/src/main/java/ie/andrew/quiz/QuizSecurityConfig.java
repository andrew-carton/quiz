package ie.andrew.quiz;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class QuizSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/styles/**").permitAll();
		http.authorizeRequests().antMatchers("/images/**").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/registerUser").permitAll();
		http.authorizeRequests().antMatchers("/scores").permitAll();
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true);                                         
        
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").loginProcessingUrl("/authenticateUser").permitAll();
	}


}
