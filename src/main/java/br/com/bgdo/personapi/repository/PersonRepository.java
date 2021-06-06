package br.com.bgdo.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bgdo.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
  
}
