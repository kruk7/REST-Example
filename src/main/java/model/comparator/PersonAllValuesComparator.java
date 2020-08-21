package model.comparator;

import model.Person;

import java.util.Comparator;

public class PersonAllValuesComparator implements Comparator<Person>
{
    @Override
    public int compare(Person p1, Person p2)
    {
        int result = p1.getFirstName().compareTo(p2.getFirstName());
        if (result == 0)
        {
            result = p1.getLastName().compareTo(p2.getLastName());
            if (result == 0)
            {
                result = Integer.compare(p1.getAge(), p2.getAge());
                return result;
            }
            return result;
        }
        return result;
    }
}
