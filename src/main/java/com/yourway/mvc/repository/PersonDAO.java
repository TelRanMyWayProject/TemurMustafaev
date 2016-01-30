package com.yourway.mvc.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.yourway.mvc.entities.Person;
import com.yourway.mvc.entities.PersonData;

@Repository
public class PersonDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public boolean addPerson(Person person) {
		if (person != null) {
			TypedQuery<Person> persons = entityManager
					.createQuery("from Person p where (p.username = ?1)" + " order by p.personId", Person.class);
			persons.setParameter(1, person.getUsername());
			List<Person> list = persons.getResultList();
			for (Person prs : list) {
				System.out.println(prs.toString());
			}
			if (list.size()== 0) {
				entityManager.persist(person);
				return true;
			}
		}
		return false;
	}

	public List<Person> findPersonByUsernameAndPassword(Person person){
		TypedQuery<Person> persons = entityManager
				.createQuery("from Person p where (p.username = ?1) and p.password = ?2" + " order by p.personId", Person.class);
		persons.setParameter(1, person.getUsername());
		persons.setParameter(2, person.getPassword());
		List<Person> list = persons.getResultList();
		return list;
	}
	
	public List<Person> findPersonByUsername(String username){
		TypedQuery<Person> persons = entityManager
				.createQuery("from Person p where (p.username = ?1) order by p.personId", Person.class);
		persons.setParameter(1, username);
		List<Person> list = persons.getResultList();
		return list;
	}
	
	public boolean setPersonData(Person person, PersonData personData){
		person.setPersonData(personData);
		Person prs = entityManager.find(Person.class, person.getPersonId());
		prs.setPersonData(personData);
		return true;
	}	
}
