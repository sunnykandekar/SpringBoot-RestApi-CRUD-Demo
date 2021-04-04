package com.springboot.RestApiProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.RestApiProject.Entities.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>
{
    public Person findById(int id);
}
