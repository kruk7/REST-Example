package model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@Entity
@Table(name = "person_details")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDetails implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;
    private String address;
    private String telephone;
    private String country;

    public PersonDetails() { }

    public PersonDetails(String address, String telephone, String country)
    {
        this.address = address;
        this.telephone = telephone;
        this.country = country;
    }

    public Long getId()
    { return id; }

    public void setId(Long id)
    { this.id = id; }

    public String getAddress()
    { return address; }

    public void setAddress(String address)
    { this.address = address; }

    public String getTelephone()
    { return telephone; }

    public void setTelephone(String telephone)
    { this.telephone = telephone; }

    public String getCountry()
    { return country; }

    public void setCountry(String country)
    { this.country = country; }

    @Override
    public String toString()
    {
        return  address + " " + telephone + " " + country;
    }
}
