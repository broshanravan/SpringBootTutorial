package spring.documenntation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwagerConfig {

    /**
     * this method will customize the html file for swagger to only include the
     * endpoints that are neededIt also would be able to customise
     * the page in order to add more details about the contents
     * @return
     */

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiDetails())
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

    private ApiInfo getApiDetails() {
        return  new ApiInfo("Mehr Computer Systems SpringBoot Maintenance",
                "Samples for Mehr Computer systems",
                "version 1.0",
                "Open Source",
                new springfox.documentation.service.Contact("Bruce Roshanravan","mehrcomputersystems.copm","broshanravan@mehecomputersystems.com"),
                "This application is licenced for private, education and commercial use",
                "www.mehrcomputersystems/licences",
                Collections.emptyList()
                );
    }

}
