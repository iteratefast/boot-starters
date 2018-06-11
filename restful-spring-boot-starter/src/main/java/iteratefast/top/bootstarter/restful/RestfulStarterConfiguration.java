package iteratefast.top.bootstarter.restful;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.DispatcherServlet;

import iteratefast.top.bootstarter.restful.validator.handler.ControllerAdviceExceptionHandler;

@Configuration
@Import({ ControllerAdviceExceptionHandler.class })
@PropertySource("classpath:starter.properties")
public class RestfulStarterConfiguration {
	@Bean
	public ServletRegistrationBean<DispatcherServlet> dispatcherRegistration(DispatcherServlet dispatcherServlet) {
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		ServletRegistrationBean<DispatcherServlet> reg = new ServletRegistrationBean<DispatcherServlet>(
				dispatcherServlet);
		return reg;
	}
}
