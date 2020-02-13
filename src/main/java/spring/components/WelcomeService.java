package spring.components;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class WelcomeService{

    public String receiveWelcomeMessage() {
        return "<i><b>What's up<b></i>";
    }

}
