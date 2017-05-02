package ae.kbgroup.sapphire.config.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ae.kbgroup.sapphire.security.config.LoginSecurityConfig;

/**
 * Created by karthikeyan.mani on 3/24/2017.
 * 
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"ae.kbgroup.sapphire.web.rest"})
@Import(LoginSecurityConfig.class)
public class SpringWebConfig {

}
