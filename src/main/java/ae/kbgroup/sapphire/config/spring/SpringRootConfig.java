package ae.kbgroup.sapphire.config.spring;

import ae.kbgroup.sapphire.security.config.LoginSecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by karthikeyan.mani on 3/24/2017.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "ae.kbgroup.sapphire.web", "ae.kbgroup.sapphire.security.config","ae.kbgroup.sapphire.security", "ae.kbgroup.sapphire.service.impl" })
@Import(JPAConfig.class)
public class SpringRootConfig {
	
	/*@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver
                          = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}*/

}
