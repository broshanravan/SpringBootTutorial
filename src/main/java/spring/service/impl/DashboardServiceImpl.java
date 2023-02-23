package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.entity.Address;
import spring.entity.Employee;
import spring.entity.Vehicle;
import spring.exceptions.EmployeeNotFoundException;
import spring.exceptions.VehicleNotFoundException;
import spring.repositories.AddressInventory;
import spring.repositories.Personnel;
import spring.repositories.VehicleRepository;
import spring.service.DashboardService;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private Personnel personnel;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    AddressInventory addressInventory;


    @RequestMapping("/saveAddress")
    public Address saveAddress(Address address){
        addressInventory.save(address);
        return address;

    }

    @RequestMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {

        Employee employee = null;
        try {
            employee  = personnel.getOne(employeeId);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            throw new EmployeeNotFoundException(employeeId);
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
        personnel.save(employee);
        return employee;
    }


    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
}
