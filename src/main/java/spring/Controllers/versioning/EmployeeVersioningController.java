package spring.Controllers.versioning;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.entity.Employee;
import spring.entity.FilteredEmployee;
import spring.repositories.FilteredPersonnel;
import spring.repositories.Personnel;

import java.util.List;
@RestController
@RequestMapping("/api/")
public class EmployeeVersioningController {

    /**
     * In this controller two different versions of employer would be returned
     * one filtered and another one not filtered
     * Hete versioning will be used for an almost identical url to
     * determine which rest Method would be called
     */


    @Autowired
    Personnel personnel;

    @Autowired
    FilteredPersonnel filteredPersonnel;

    /**
     * This approach is caled URI versioning
     * In this approach the approach will be passed as a part of the URL
     * @return
     */
    @GetMapping("v1/allEmployees")
    @ApiOperation(value ="To get all employees details with address Id filtered",
            notes= "It returns all details for a group of employees except the addressId which is not relevant",
            response= FilteredEmployee.class)
    public MappingJacksonValue retrieveEmployeesFilterVer(){
        List<FilteredEmployee> filteredEmployees = filteredPersonnel.findAll();
        SimpleBeanPropertyFilter filter  = SimpleBeanPropertyFilter.filterOutAllExcept("firstName","surname", "department");
        FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(filteredEmployees);
        mapping.setFilters(filters);
        return mapping;
    }


    @GetMapping("v2/allEmployees")
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployees = personnel.findAll();
        return allEmployees;
    }


    /**
     * this approach passed the method to be
     * called as a request parameter
     * @return
     */

    @GetMapping(value = "allEmployees/param", params ="version=1")
    @ApiOperation(value ="To get all employees details with address Id filtered",
            notes= "It returns all details for a group of employees except the addressId which is not relevant",
            response= FilteredEmployee.class)
    public MappingJacksonValue retrieveEmployeesFilterAdd(){
        List<FilteredEmployee> filteredEmployees = filteredPersonnel.findAll();
        SimpleBeanPropertyFilter filter  = SimpleBeanPropertyFilter.filterOutAllExcept("firstName","surname", "department");
        FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(filteredEmployees);
        mapping.setFilters(filters);
        return mapping;
    }


    @GetMapping(value = "allEmployees/param", params ="version=2")
    public List<Employee> getAllEmployeesReqParams() {
        List<Employee> allEmployees = personnel.findAll();
        return allEmployees;
    }


    /**
     * Here the method to be called is passed and a request header
     * @return
     */

    @GetMapping(value = "/allEmployees/header", headers ="X-API-VERSION=1")
    @ApiOperation(value ="To get all employees details with address Id filtered",
            notes= "It returns all details for a group of employees except the addressId which is not relevant",
            response= FilteredEmployee.class)
    public MappingJacksonValue retrieveEmployeesFilterAddHdr(){
        List<FilteredEmployee> filteredEmployees = filteredPersonnel.findAll();
        SimpleBeanPropertyFilter filter  = SimpleBeanPropertyFilter.filterOutAllExcept("firstName","surname", "department");
        FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(filteredEmployees);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping(value = "/allEmployees/header", headers ="X-API-VERSION=2")
    public List<Employee> getAllEmployeesHdr() {
        List<Employee> allEmployees = personnel.findAll();
        return allEmployees;
    }


    /**
     * uses the header parameter "Accept"
     * this also called mime type versioning
     * @return
     */

    @GetMapping(value = "/allEmployees/produces", produces ="Application/vnd.company.app-v1+json")
    @ApiOperation(value ="To get all employees details with address Id filtered",
            notes= "It returns all details for a group of employees except the addressId which is not relevant",
            response= FilteredEmployee.class)
    public MappingJacksonValue retrieveEmployeesFilterAddProd(){
        List<FilteredEmployee> filteredEmployees = filteredPersonnel.findAll();
        SimpleBeanPropertyFilter filter  = SimpleBeanPropertyFilter.filterOutAllExcept("firstName","surname", "department");
        FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(filteredEmployees);
        mapping.setFilters(filters);
        return mapping;
    }


    @GetMapping(value = "/allEmployees/produces", produces ="Application/vnd.company.app-v2+json")
    public List<Employee> getAllEmployeesProd() {
        List<Employee> allEmployees = personnel.findAll();
        return allEmployees;
    }


}
