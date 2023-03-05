package spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.beans.Course;
import spring.beans.CourseConfiguration;
import spring.entity.Address;
import spring.entity.Employee;
import spring.exceptions.EmployeeNotFoundException;
import spring.repositories.AddressInventory;
import spring.repositories.Personnel;
import spring.service.impl.DashboardServiceImpl;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping("/api/")
public class RestEndpoint {


    @Value("${default.course.name}")
    private String cName;


    @Value("${default.course.chapters}")
    private int chapters;

    @Autowired
    private DashboardServiceImpl dashboardServiceImpl;

    @Autowired
    private CourseConfiguration courseConfiguration;

    @Autowired
    private Personnel personnel;

    @Autowired
    AddressInventory addressInventory;

    @GetMapping("/getHierarchical")
    public  HashMap<String,Object> getDAnnotatedProperties(){

        HashMap<String,Object> courseMap = new HashMap<String,Object>();

        System.out.println("----------------------" + courseConfiguration.getName());
        courseMap.put("name", courseConfiguration.getName());
        courseMap.put("chapters", courseConfiguration.getChapters());
        courseMap.put("rating", courseConfiguration.getRating());
        courseMap.put("author", courseConfiguration.getAuthor());


        return courseMap;
    }


    @GetMapping("/defaultCourse")
    public Course getDefaultEndPoint(@RequestParam(value ="name" ,defaultValue = "SpringBoot", required = false)String name,
                              @RequestParam(value ="chapterCount" ,defaultValue = "3", required = false) int chapterCount
    ){

        return new Course(cName, chapters);
    }

    @GetMapping("/course")
    public Course getEndPoint(@RequestParam(value ="name" ,defaultValue = "SpringBoot", required = false) String name,
                              @RequestParam(value ="chapterCount" ,defaultValue = "3", required = false) int chapterCount
    ){

        return new Course(name, chapterCount);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/course")
    public String saveCourse(@RequestBody Course course) {
        String courseInfo = " your course Name = " + course.getName() +
                " and your course has " +  course.getChapterCount() + " chapters has been saved";
        System.out.println(courseInfo);
        return courseInfo;
    }

    @RequestMapping("/employee/{employeeId}")
    public Resource<Employee> getEmployeeById(@PathVariable int employeeId)  {

        /**
         * HATEOAS all employees link to other methods
         * This feature can all link to all other method
         * the advantage is that in case the link for child method is changed
         * the lonk provided by parent method does not need to be changef
         */
        Resource<Employee> employeeResource = null;
        try{
            Employee employee = personnel.getOne(employeeId);
            employee.show();

            employeeResource = new Resource<Employee>(employee);
            ControllerLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).getAllEmployees());

            employeeResource.add(linkTo.withRel("all-employees"));


        }catch(Exception e){
            e.printStackTrace();
            throw  new EmployeeNotFoundException(employeeId);
        }

        return employeeResource;
    }


    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = dashboardServiceImpl.getAllEmployees();
        return allEmployees;
    }


    @PostMapping("/saveEmployee")
    public ResponseEntity savelEmployees(@RequestBody Employee employee) {

        dashboardServiceImpl.saveEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getEmployeeId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployees(@RequestBody Employee employee) {
        return dashboardServiceImpl.saveEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public void deleteEmployee(@RequestBody int employeeId) {
        Employee employee = personnel.getOne(employeeId);

        if(employee == null ){
            throw (new EmployeeNotFoundException(employeeId));
        }
        personnel.delete(employee);
    }

    @GetMapping("/address/{addressId}")
    public Resource<Address>  getAddressById(@PathVariable int addressId){
        List<Address> addressList = addressInventory.findAll();
        Resource<Address> addressResource = null;
        try{
            Address address = addressInventory.getOne(addressId);
            address.show();

            addressResource = new Resource<Address>(address);
            ControllerLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).getAllAddresses());

            addressResource.add(linkTo.withRel("all-addresses"));

        }catch(Exception e){
            e.printStackTrace();
            throw  new EmployeeNotFoundException(addressId);
        }

        return addressResource;
    }

    @GetMapping("/address")
    public List<Address> getAllAddresses(){
        List<Address> addressList = addressInventory.findAll();
        return addressList;
    }

}
