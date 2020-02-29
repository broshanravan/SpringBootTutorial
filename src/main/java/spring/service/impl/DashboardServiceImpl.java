package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.entity.Employee;
import spring.repositories.Personnel;
import spring.service.DashboardService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class DashboardServiceImpl implements DashboardService {


    @Autowired
    private Personnel personnel;

    @Override
    public Employee getEmployeeById(int employeeId) throws EntityNotFoundException{

        Employee employee = personnel.getOne(employeeId);

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
