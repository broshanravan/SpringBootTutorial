package spring.service;

import spring.entity.Employee;
import spring.entity.Vehicle;

import java.util.List;

public interface DashboardService {

    public Employee getEmployeeById(int employeeId);
    public List<Employee> getAllEmployees();
    public Employee saveEmployee(Employee employee);
    public Vehicle getVehiccleById(int VehicleId);

}
