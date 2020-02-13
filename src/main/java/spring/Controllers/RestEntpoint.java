package spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import spring.beans.Course;
import spring.beans.CourseConfiguration;
import spring.entity.Employee;
import spring.service.impl.DashboardServiceImpl;

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


    @RequestMapping("/defaultCourse")
    public Course getDefaultEndPoint(@RequestParam(value ="name" ,defaultValue = "SpringBoot", required = false) String name,
                              @RequestParam(value ="chapterCount" ,defaultValue = "3", required = false) int chapterCount
    ){

        return new Course(cName, chapters);
    }

    @RequestMapping("/course")
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

    @RequestMapping("/getEmployeeById")
    public Employee getEmployeeById(@RequestParam(value ="employeeId" ,defaultValue = "1") int empId) {
        Employee employee = dashboardServiceImpl.getEmployeeById(empId);
        employee.show();
        return employee;

    }

    @RequestMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return dashboardServiceImpl.getAllEmployees();

    }

    @RequestMapping("/saveEmployee")
    public Employee savelEmployees(@RequestBody Employee employee) {
        return dashboardServiceImpl.saveEmployee(employee);
    }

    @RequestMapping("/updateEmployee")
    public Employee updateEmployees(@RequestBody Employee employee) {
        return dashboardServiceImpl.saveEmployee(employee);
    }



}
