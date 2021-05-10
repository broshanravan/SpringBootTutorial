package spring.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="employee", schema = "Mehr_Test")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@JsonFilter("EmployeeFilter")
public class FilteredEmployee implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name ="employee_id", unique = true, nullable = false)
        private int employeeId;

        @Column(name="first_name")
        @Size(min =2, message= "name should have at least two characters")
        private String firstName;

        @Size(min =3, message= "surname should have at least three characters")
        @Column(name="surname")
        private String surname;

        @Column(name="department")
        private String department;

        @Column(name="address_id")
        private int addressId;

        public FilteredEmployee(int employeeId, String firstName, String surname, String department, int addressId) {
            this.employeeId = employeeId;
            this.firstName = firstName;
            this.surname = surname;
            this.department = department;
            this.addressId = addressId;
        }

        public FilteredEmployee(String firstName, String surname, String department, int addressId) {
            this.firstName = firstName;
            this.surname = surname;
            this.department = department;
            this.addressId = addressId;
        }

        public FilteredEmployee() {


        }

        public FilteredEmployee(Employee employee) {
            this.employeeId = employee.getEmployeeId();
            this.firstName = employee.getFirstName();
            this.surname = employee.getSurname();
            this.department = employee.getDepartment();
            this.addressId = employee.getAddressId();

        }

        @JsonProperty
        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        @JsonProperty
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @JsonProperty
        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        @JsonProperty
        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        @JsonProperty
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
