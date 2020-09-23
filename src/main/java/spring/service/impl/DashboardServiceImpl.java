package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.entity.Employee;
import spring.exceptions.EmployeeNotFoundException;
import spring.repositories.Personnel;
import spring.service.DashboardService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class DashboardServiceImpl implements DashboardService {


    @Autowired
    private Personnel personnel;

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) throws EmployeeNotFoundException {

        Employee employee = personnel.getOne(employeeId);
        if(employee == null){
            throw new EmployeeNotFoundException("id-" + employeeId);
        }

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return personnel.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee){
        return personnel.save(employee);
    }


    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
}
