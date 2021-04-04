package com.springboot.RestApiProject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.RestApiProject.Entities.Person;
import com.springboot.RestApiProject.services.PersonServices;

@RestController
public class PersonController 
{               
	        @Autowired
 			private PersonServices personServices;
			
	     // for all person list handeler
	        
			@GetMapping("/person")
			public ResponseEntity<List<Person>>getperson()            
            {
			 List<Person> list=personServices.getAllPerson();
				if(list.size()<=0)
				{
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();		    		  
			    }
				return ResponseEntity.status(HttpStatus.CREATED).body(list);
            }// end get all
			
			// for get single person by id  handeler
			
			@GetMapping("/person/{id}")
			public ResponseEntity<Person> getPerson(@PathVariable("id") int id)  
			{ 
			  
			    Person person = personServices.getPersonById(id);
				  if(person==null)
				  {
				    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
						//personServices.getPersonById(id);
			       }
				  return ResponseEntity.status(HttpStatus.CREATED).body(person);
		   	}// end get byid
			
			// add/insert/save/create handeler
			
			@PostMapping("/person")
			public ResponseEntity<Person> addPerson(@RequestBody Person person)
			{ 
				Person p=null;
				try {
					 p= this.personServices.addPerson(person);
					System.out.println(person);
					return ResponseEntity.status(HttpStatus.CREATED).body(p);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
				
			}// end save/insert/create
			
			// delete  handeler
			
			@DeleteMapping("person/{personId}")
			public ResponseEntity<Person> deletePerson(@PathVariable("personId") int personId)
			{
				
				try {
					 this.personServices.deletePerson(personId);
				
					 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
				
			}// end delete
			
			// update handeler
			
			@PutMapping("person/{personId}")
			public ResponseEntity<Person> updatePesron(@RequestBody Person person,@PathVariable("personId") int personId)
			{
		      	
		      	try {
		      		this.personServices.updatePesron(person,personId);
				
					 return ResponseEntity.ok().body(person);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
			}// end update
}

























