package com.springboot.RestApiProject.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Person 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "person_Id")
     private int id;
     private String name;
     
     @OneToOne(cascade=CascadeType.ALL)
     @JsonManagedReference
     private City city;
     
                   // setter getter
     
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}

	                    //para constructor
	
	public Person(int id, String name, City city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	                    //default constructor
	public Person() {
		super();


	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
     
	              
	
     
}








































