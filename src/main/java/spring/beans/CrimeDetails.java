package spring.beans;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="CRIME_LOCATION", schema = "MOJt")

public class CrimeDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="detail_id", unique = true, nullable = false)
    public int LocationID;

    @Column(name="fcategury")
    public String categurey;

    @Column(name="location_id")
    public Location locationId;


}
