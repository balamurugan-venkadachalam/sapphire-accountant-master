package ae.kbgroup.sapphire.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import ae.kbgroup.sapphire.config.spring.JPAConfig;
import ae.kbgroup.sapphire.security.AuthFailureHandler;
import ae.kbgroup.sapphire.security.AuthSuccessHandler;
import ae.kbgroup.sapphire.security.CustomFilter;
import ae.kbgroup.sapphire.security.HttpLogoutSuccessHandler;



@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String LOGIN_PATH = "/service/login";

	private static String REALM = "MY_TEST_REALM";

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	@Qualifier("customAccessDeniedHandler")
	AccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	AuthSuccessHandler authSuccessHandler;

	
	@Autowired
	@Qualifier("customBasicAuthenticationEntryPoint")
	CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;
	
	@Autowired
	AuthFailureHandler authFailureHandler;
    
    @Autowired
    private HttpLogoutSuccessHandler logoutSuccessHandler;
    
    @Autowired
    @Qualifier(value="customFilter")
    private GenericFilterBean customFilter;

	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() throws Exception {
		return new MappingJackson2HttpMessageConverter();
	}




	@Override
	protected void configure(HttpSecurity http) throws Exception {
		

	/*	http.authorizeRequests()
		.antMatchers("/service/user/**").hasRole("USER")
		.antMatchers("/service/admin/**").hasRole("ADMIN")
		.antMatchers("/css/**").permitAll()
		.antMatchers("/js/**").permitAll()
		.antMatchers("/app/**").permitAll()
		.antMatchers("/index.html").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/logout").permitAll()
        .anyRequest().authenticated()
        .and()
        .authenticationProvider(authenticationProvider())
        .exceptionHandling()
        .authenticationEntryPoint(customBasicAuthenticationEntryPoint)
        .and()
        .formLogin()
        .permitAll()
        .loginProcessingUrl("/login")
        .usernameParameter("username")
        .passwordParameter("password")
        .successHandler(authSuccessHandler)
        .failureHandler(authFailureHandler)
        .and()
        .logout()
        .permitAll()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().exceptionHandling().accessDeniedHandler(accessDeniedHandler)
		.and().csrf().disable();
		
		http.authorizeRequests().anyRequest().authenticated();*/
		
	//	http.addFilterBefore( customFilter, ChannelProcessingFilter.class);
		
		  http.csrf().disable()
          .authorizeRequests()
          .antMatchers("/", "/app/**","/css/**","/js/**","/partials/public/**", "/partials/admin/menu/*" ).permitAll()
  		  .antMatchers("/service/user/**").hasRole("USER")
  		  .antMatchers("/service/admin/**", "/service/invMgmt/**","/partials/admin/**").hasRole("ADMIN")
          .antMatchers("/index.html").permitAll()          
          .anyRequest().authenticated()         
          .and()
          .authenticationProvider(authenticationProvider())
          .exceptionHandling()
          .authenticationEntryPoint(customBasicAuthenticationEntryPoint)
          .and()
          .formLogin()
          .permitAll()
          .loginProcessingUrl(LOGIN_PATH)
          .usernameParameter("username")
          .passwordParameter("password")
          .successHandler(authSuccessHandler)
          .failureHandler(authFailureHandler)
          .and()
          .logout()
          .permitAll()
          .logoutRequestMatcher(new AntPathRequestMatcher(LOGIN_PATH, "DELETE"))
          .logoutSuccessHandler(logoutSuccessHandler)
          .and()
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
          .maximumSessions(1);

		  http.authorizeRequests().anyRequest().authenticated();
		
	}

	/* To allow Pre-flight [OPTIONS] request from browser */
/*	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
		web.ignoring().antMatchers("/app**", "/css**", "/js**");

	}*/

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		//authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}