package top.iteratefast.bootstarter.restful;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import top.iteratefast.bootstarter.restful.validator.handler.ControllerAdviceExceptionHandler;

@Configuration
@Import({ ControllerAdviceExceptionHandler.class })
@PropertySource("classpath:starter.properties")
public class RestfulStarterConfiguration {
}
