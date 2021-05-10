package spring.Controllers.filters;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.entity.Employee;
import spring.entity.FilteredEmployee;
import spring.repositories.FilteredPersonnel;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class FilterEmployeeIController {

    @Autowired
    FilteredPersonnel personnel;

    /**
     * The Anotation '@ApiOperation' is used to add more details in
     * swagger html documentation
     * @return
     */
    @GetMapping("/filteredEmployees")
    @ApiOperation(value ="To get all employees details with address Id filtered",
            notes= "It returns all details for a group of employees except the addressId which is not relevant",
            response=Employee.class)
    public MappingJacksonValue retrieveEmployeesFilterAdd(){
        List<FilteredEmployee> employees = personnel.findAll();
        SimpleBeanPropertyFilter filter  = SimpleBeanPropertyFilter.filterOutAllExcept("firstName","surname", "department");
        FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(employees);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/filteredEmployee/{employeeId}")
    @ApiOperation(value ="To get an employee details with address Id filtered",
            notes= "It returns all details for a particular employee except the addressId which is not relevant",
            response=Employee.class)
    public MappingJacksonValue retrieveOneEmployeeFilterAdd(@ApiParam(value="The Id number you need to pass in order to get the details of the employee",
        required =true) @PathVariable int employeeId){

        FilteredEmployee filteredEmployee = personnel.getOne(employeeId);
        SimpleBeanPropertyFilter filter  = SimpleBeanPropertyFilter.filterOutAllExcept("firstName","surname", "department");
        FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(filteredEmployee);
        mapping.setFilters(filters);
        return mapping;
    }

}
