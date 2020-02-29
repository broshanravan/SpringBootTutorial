package spring.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.beans.HelloBean;
import spring.components.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService service;


    @RequestMapping("/welcome")
    public String welcome(){
        return  service.receiveWelcomeMessage();//"<b>welcome to my first SpringBoot page:</b>";
    }


    /**Functions with path variable */

    @GetMapping("hello-sir/path-variable/{message}/{name}")
    public HelloBean helloWithPathVariable(@PathVariable String name, @PathVariable String message){
        return new HelloBean(String.format("Hello Mr, %s", name),String.format("Your message is:, %s", message));

    }

}
