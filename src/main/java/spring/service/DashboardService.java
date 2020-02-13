package spring.service;

import spring.entity.Employee;

import java.util.List;

public interface DashboardService {

    public Employee getEmployeeById(int employeeId);
    public List<Employee> getAllEmployees();
    public Employee saveEmployee(Employee employee);

}
