package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.SpringBootApp;
import spring.entity.Employee;
import spring.service.DashboardService;

import java.util.List;

@Component
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private SpringBootApp.Personnel personnel;

    @Override
    public Employee getEmployeeById(int employeeId){
        return personnel.getOne(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return personnel.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee){
        return personnel.save(employee);
    }
}
