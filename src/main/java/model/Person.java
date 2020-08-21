package model;

import java.util.Objects;

public class Person implements Comparable<Person>
{
    private String firstName;
    private String lastName;
    private String pesel;
    private int age;

    public Person(String firstName, String lastName, String pesel, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.age = age;
    }

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
    public int compareTo(Person o)
    {
        int result = this.firstName.compareTo(o.firstName);
        if (result == 0)
        {
            result = this.lastName.compareTo(o.lastName);
            if (result == 0)
            {
                result = o.age - this.age;
                return result;
            }
            return result;
        }
        return result;
    }

    @Override
    public String toString()
    {
        return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", pesel='" + pesel + '\'' + ", age=" + age + '}';
    }
}