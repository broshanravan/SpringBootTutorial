package spring.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.entity.Employee;

@Repository
@Qualifier(value ="personnel")
public interface Personnel extends JpaRepository<Employee,Integer>{

}
