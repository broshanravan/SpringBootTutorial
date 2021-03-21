package spring.components;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class WelcomeService{

    public String receiveWelcomeMessage() {
        return "<b><i><h1>What's up</h1></i></b>";
    }

    public String receiveWelcomeMessageInternationalized() {
        return "<b><i><h1>Hello World</h1></i></b>";
    }

}
