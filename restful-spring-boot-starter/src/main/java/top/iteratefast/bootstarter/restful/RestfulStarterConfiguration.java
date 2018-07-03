package top.iteratefast.bootstarter.restful;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import top.iteratefast.bootstarter.restful.validator.handler.ControllerAdviceExceptionHandler;
import top.iteratefast.bootstarter.restful.validator.handler.CustomErrorAttributesConfiguration;

@Configuration
@Import({ ControllerAdviceExceptionHandler.class, CustomErrorAttributesConfiguration.class })
@PropertySource("classpath:starter.properties")
public class RestfulStarterConfiguration {
}
