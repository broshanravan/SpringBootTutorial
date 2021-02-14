package spring.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.entity.Employee;
import spring.entity.Vehicle;

@Repository
@Qualifier(value ="vehicle")
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {


}
