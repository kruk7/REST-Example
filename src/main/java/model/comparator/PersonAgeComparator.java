package model.comparator;

import model.Person;

import javax.naming.InsufficientResourcesException;
import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person>
{
    @Override
    public int compare(Person p1, Person p2)
    {
        int result = Integer.compare(p1.getAge(), p2.getAge());
        return result;
    }
}
