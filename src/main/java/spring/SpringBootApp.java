package spring;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import spring.entity.Employee;

import java.util.Locale;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "spring.repositories")
@EntityScan(basePackages = "spring.entity")
@ComponentScan
public class SpringBootApp {

    public static void main(String[] args){
       SpringApplication.run(SpringBootApp.class, args);

    }


    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver locateResolver = new SessionLocaleResolver();
        locateResolver.setDefaultLocale(Locale.UK);
        return locateResolver;
    }


    @Bean
    public ResourceBundleMessageSource bundleMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;

    }

}
