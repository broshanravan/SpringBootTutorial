package spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_project", schema = "mehr_dev")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class EmployeeProjects {

    public EmployeeProjects(){

    }

    @Id
    @Column(name = "")
    private int id;

    @Column(name = "")
    private int employeeId;

    @Column(name = "")
    private int projectId;

    public EmployeeProjects(int id, int employeeId, int projectId) {
        this.id = id;
        this.employeeId = employeeId;
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "EmployeeProjects{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", projectId=" + projectId +
                '}';
    }
}
