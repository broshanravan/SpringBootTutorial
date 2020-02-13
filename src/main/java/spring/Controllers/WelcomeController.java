package spring.Controllers;

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

}
