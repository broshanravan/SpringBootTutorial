package spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project", schema = "mehr_dev")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Project {

    @Id
    @Column(name ="PROIECT_ID")
    private int projectId;

    @Column(name ="PROJECT_NAME")
    private String projectName;
    @Column(name ="PROJECT_OWNER")
    private String projectOwner;

    @Column(name ="ADDRESS_ID")
    private int addressId;

    @Column(name ="BUDJET_IN_POUNDS")
    private double budjetPounds;

    public Project() {
    }

    public Project(int projectId, String projectName, String projectOwner, int addressId, double budjetPounds) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectOwner = projectOwner;
        this.addressId = addressId;
        this.budjetPounds = budjetPounds;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(String projectOwner) {
        this.projectOwner = projectOwner;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public double getBudjetPounds() {
        return budjetPounds;
    }

    public void setBudjetPounds(double budjetPounds) {
        this.budjetPounds = budjetPounds;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectOwner='" + projectOwner + '\'' +
                ", addressId=" + addressId +
                ", budjetPounds=" + budjetPounds +
                '}';
    }
}
