package spring.Controllers;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import spring.beans.HelloBean;
import spring.components.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @Autowired
    private MessageSource messageSource;
    //private Locale locale;

    @RequestMapping("/welcome")
    public String welcome(){
        return  service.receiveWelcomeMessage();//"<b>welcome to my first SpringBoot page:</b>";
    }

    @RequestMapping("/welcome-internationalized")
    public String welcomeInternationalized() {
        return service.receiveWelcomeMessageInternationalized();
    }

    /**Functions with path variable */



    @GetMapping("/hello-sir/path-variable/{message}/{name}")
    public HelloBean helloWithPathVariable(@PathVariable String name, @PathVariable String message){
        return new HelloBean(String.format("Hello Mr, %s", name),String.format("Your message is:, %s", message));

    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required =false) Locale locale){
        return messageSource.getMessage("good.morning.message", null, locale);

    }





}
