package model.comparator;

import model.Person;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person>
{
    @Override
    public int compare(Person p1, Person p2)
    {
        int result = p1.getFirstName().compareTo(p2.getFirstName());
        return result;
    }
}
