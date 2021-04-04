package com.springboot.RestApiProject.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class City 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "city_Id")
	private int cid;
	private String street;
    private String cityName;
    
    @OneToOne(mappedBy = "city")
    @JsonBackReference
    private Person person;


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public City(int cid, String street, String cityName, Person person) {
		super();
		this.cid = cid;
		this.street = street;
		this.cityName = cityName;
		this.person = person;
	}


	public City() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "City [cid=" + cid + ", street=" + street + ", cityName=" + cityName + ", person=" + person + "]";
	}


	
    



}
