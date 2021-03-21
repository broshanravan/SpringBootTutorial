package spring.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.entity.Address;

@Repository
@Qualifier(value ="address")
public interface AddressInventory extends JpaRepository<Address,Integer> {
}
