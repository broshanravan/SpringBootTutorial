package spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="address", schema = "Mehr_Test")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Address implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="address_id", unique = true, nullable = false)
    private int addressId;

    @Column(name ="house_name_number")
    private String houseNameNumber;

    @Column(name ="address_1")
    private String address_1;

    @Column(name ="address_2")
    private String address_2;

    @Column(name ="post_code")
    private String postCode;

    @Column(name ="city")
    private String city;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getHouseNameNumber() {
        return houseNameNumber;
    }

    public void setHouseNameNumber(String houseNameNumber) {
        this.houseNameNumber = houseNameNumber;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void show() {
        System.out.println("addressId = " + addressId);
        System.out.println("houseNameNumber = " + houseNameNumber);
        System.out.println("address_1 = " + address_1);
        System.out.println("address_2 = " + address_2);
        System.out.println("postCode = " + postCode);
        System.out.println("city = " + city);
    }
}
