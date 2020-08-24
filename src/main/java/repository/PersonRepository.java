package repository;

import model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PersonRepository
{
    @PersistenceContext
    private EntityManager em;

    public void add(Person person)
    {
        em.persist(person);
    }

    public Person getById(Long id)
    {
        TypedQuery<Person> query = em.createNamedQuery("findById", Person.class);
        query.setParameter("id", id);
        List<Person> resultList = query.getResultList();
        if (resultList.isEmpty()) return null;
        else return resultList.get(0);
    }

    public List<Person> getAll()
    {
        TypedQuery<Person> query = em.createNamedQuery("findAll", Person.class);
        return query.getResultList();
    }
}