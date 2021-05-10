package spring.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.entity.FilteredEmployee;

@Repository
@Qualifier(value ="filteredPersonnel")

public interface FilteredPersonnel extends JpaRepository<FilteredEmployee,Integer> {

}
