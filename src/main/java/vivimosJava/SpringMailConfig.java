
package vivimosJava;

import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class SpringMailConfig {
	
	@Bean
	public ITemplateResolver thymeleafClassLoaderTemplateResolver() {
	    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	    templateResolver.setPrefix("templates/");
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode("HTML");
	    templateResolver.setCharacterEncoding("UTF-8");
	    return templateResolver;
	}


	@Bean
	public SpringTemplateEngine thymeleafTemplateEngine() {
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(thymeleafClassLoaderTemplateResolver());
	    
	    return templateEngine;
	}
	

	@Bean
	public ResourceBundleMessageSource emailMessageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("mailMessages");
	    return messageSource;
	}
}
