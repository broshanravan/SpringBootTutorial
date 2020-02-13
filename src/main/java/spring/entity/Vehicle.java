package spring.entity;



import javax.persistence.*;

@Entity
@Table(name ="vehicle", schema="mehr_dev")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="vehicleId", unique = true, nullable = false)
    private int vehicleId;

    @Column(name="regNumber")
    private String regNumber;

    @Column(name="make")
    private String make;

    @Column(name="model")
    private String model;


    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
