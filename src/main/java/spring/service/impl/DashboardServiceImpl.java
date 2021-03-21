package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.entity.Employee;
import spring.entity.Vehicle;
import spring.exceptions.EmployeeNotFoundException;
import spring.exceptions.VehicleNotFoundException;
import spring.repositories.Personnel;
import spring.repositories.VehicleRepository;
import spring.service.DashboardService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class DashboardServiceImpl implements DashboardService {


    @Autowired
    private Personnel personnel;

    @Autowired
    VehicleRepository vehicleRepository;

    @RequestMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {

        Employee employee = personnel.getOne(employeeId);
        if(employee == null){

        }

        return employee;
    }

    @RequestMapping("/vehicles/{vehicleId}")
    public Vehicle getVehicleById(@PathVariable int vehicleId) {

        Vehicle vehicle = vehicleRepository.getOne(vehicleId);
        if(vehicle == null){
            throw new VehicleNotFoundException("id-" + vehicleId);
        }

        return vehicle;
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
