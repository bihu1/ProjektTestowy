package pl.bihuniak.ProjektTestowy;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hotel {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ElementCollection
    private List<Address> addresses;

    public Hotel() {}

    public Hotel(long id, String name, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}