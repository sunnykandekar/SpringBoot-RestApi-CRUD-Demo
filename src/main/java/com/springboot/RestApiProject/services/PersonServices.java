package com.springboot.RestApiProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.RestApiProject.Entities.Person;
import com.springboot.RestApiProject.repository.PersonRepository;


@Component
public class PersonServices 
{
 
	/*private static List<Person> list = new ArrayList<>();  // created fake service database
	
	static                // used static block
	{
	      list.add(new Person(101,"Akshay Kumar","Mumbai"));
	      list.add(new Person(102,"Salman Khan","New Mumbai"));
	      list.add(new Person(103,"Shahrukh khan","Delhi"));
	}
	 */
	
	    @Autowired
	     private PersonRepository personRepository;
	    
	       // get all person list
	public List<Person>getAllPerson()
	{
		List<Person> list=  (List<Person>) this.personRepository.findAll();
		return list;
		
	}
	                  // get person by id
	public Person getPersonById(int id)
	{
		Person person=null;
		try{
			   person = this.personRepository.findById(id);
	     	}
       catch(Exception e)
		   {
			e.printStackTrace();
		   }
		
		      /*    // also can be used   for-each loop condition
		    person=list.stream().filter(e->e.getId()==id).findFirst().get(); //here used stream() apli of collection
            */		    
		    
	       return person;
	}
	
	// add person
	public Person addPerson(Person person)
	{
	     Person result=this.personRepository.save(person);
    		return result;
	}
	
	/*// delete person
	public void deletePerson(int pid)
	{
		list=list.stream().filter(person->{
			if(person.getId()!=pid)
		      	{
				return true;
		      	}
			else
			{
				return false;
			}
		}).collect(Collectors.toList());
	}; */ // end deletePerson
	
	// or Another method
	
	// delete person by id
		public void deletePerson(int pid)
		{
			//list=list.stream().filter(person->(person.getId()!=pid)).collect(Collectors.toList());
			personRepository.deleteById(pid);
		}
		
		// update person
		public void updatePesron(Person person, int personId)
		{
		/*list = list.stream().map(p->{
			  if(p.getId()==personId)
			    {
				   p.setName(person.getName());
				   p.setCity(person.getCity());
			    }
			 return p;
		  }).collect(Collectors.toList());	
	  */
			  person.setId(personId);
			personRepository.save(person);
		}
}












