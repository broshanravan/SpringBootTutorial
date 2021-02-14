package spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.beans.Course;
import spring.beans.CourseConfiguration;
import spring.entity.Employee;
import spring.exceptions.EmployeeNotFoundException;
import spring.service.impl.DashboardServiceImpl;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RestController
public class RestEntpoint {


    @Value("${default.course.name}")
    private String cName;


    @Value("${default.course.chapters}")
    private int chapters;

    @Autowired
    private DashboardServiceImpl dashboardServiceImpl;

    @Autowired
    private CourseConfiguration courseConfiguration;

    @RequestMapping("/getHierarchical")
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

    @GetMapping("/getEmployeeById/{empId}")
    public Employee getEmployeeById(@PathVariable int empId) {
        boolean validSearchResults = true;
        Employee employee = null;
        employee = dashboardServiceImpl.getEmployeeById(empId);
        System.out.println("_____________ GET EMPLOYEE BY ID______________");
        if(employee.getFirstName() == null){
            System.out.println("_____________inside Exception______________");
            throw new EmployeeNotFoundException("id-" + empId);
        }


        try {
            employee.show();
        }catch (EmployeeNotFoundException enfe) {
            System.out.println("======================================In Not found Exception");
            //System.out.println(enfe.getMessage());
        }



        return employee;

    }

    @RequestMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return dashboardServiceImpl.getAllEmployees();

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



}
