package model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "findAll", query = "SELECT p FROM Person p"),
                @NamedQuery(name = "findById", query = "SELECT p FROM Person p WHERE p.id = :id")
        }
)
@XmlRootElement
@Table(name = "persons")
public class Person implements Serializable
{
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String pesel;
    private int age;
    @OneToOne(cascade = CascadeType.ALL)
    private PersonDetails personDetails;

    public Person() {}

    public Person(String firstName, String lastName, String pesel, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.age = age;
    }

    public Long getId()
    { return id; }


    public String getFirstName()
    { return firstName; }

    public void setFirstName(String firstName)
    { this.firstName = firstName; }

    public String getLastName()
    { return lastName; }

    public void setLastName(String lastName)
    { this.lastName = lastName; }

    public String getPesel()
    { return pesel; }

    public void setPesel(String pesel)
    { this.pesel = pesel; }

    public int getAge()
    { return age; }

    public void setAge(int age)
    { this.age = age; }

    public PersonDetails getPersonDetails()
    { return personDetails; }

    public void setPersonDetails(PersonDetails personDetails)
    { this.personDetails = personDetails; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(pesel, person.pesel);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(firstName, lastName, pesel, age);
    }

    @Override
    public String toString()
    {
        return  firstName + " " + lastName + " " + pesel + " " + age + " " + personDetails.toString();
    }
}
