package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
;

import java.util.Locale;



//
@SpringBootApplication
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
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;

    }

}
