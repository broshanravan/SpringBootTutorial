package spring;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import spring.entity.Employee;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "spring.repositories")
@EntityScan(basePackages = "spring.entity")
@ComponentScan
public class SpringBootApp {

    public static void main(String[] args){
       SpringApplication.run(SpringBootApp.class, args);

    }

    /*
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }


    @Repository
    @Qualifier(value ="personnel")
    public static interface Personnel extends JpaRepository<Employee,Integer> {
    }
    */
}
