package spring.entity;

import javax.persistence.*;

@Entity
@Table(name="employee", schema = "mehr_dev")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="employee_id", unique = true, nullable = false)
    private int employeeId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="surname")
    private String surname;

    @Column(name="department")
    private String department;

    @Column(name="address_id")
    private int addressId;

    public Employee(int employeeId, String firstName, String surname, String department, int addressId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.surname = surname;
        this.department = department;
        this.addressId = addressId;
    }

    public Employee() {

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void show(){
        System.out.println("employeeId = " + employeeId);
        System.out.println("firstName = " + firstName);
        System.out.println("surname = " + surname);
        System.out.println("department = " + department);
        System.out.println("addressId = " + addressId);

    }



}
