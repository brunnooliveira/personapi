package br.com.bgdo.personapi.service;

import org.springframework.stereotype.Service;

import br.com.bgdo.personapi.dto.response.MessageResponseDTO;
import br.com.bgdo.personapi.entity.Person;
import br.com.bgdo.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  public MessageResponseDTO createPerson(Person person) {
    Person savedPerson = personRepository.save(person);
    return MessageResponseDTO.builder().message("Created person with ID: " + savedPerson.getId()).build();
  }

}
