package spring.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CRIME_LOCATION", schema = "MOJt")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="location_id", unique = true, nullable = false)
    private long locationId;

    @Column(name="longtitud")
    private double longtitud;

    @Column(name="latitued")
    private double latitued;

    public double getLongtitud() {
        return longtitud;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public void setLongtitud(double longtitud) {
        this.longtitud = longtitud;
    }

    public double getLatitued() {
        return latitued;
    }

    public void setLatitued(double latitued) {
        this.latitued = latitued;
    }
}
