package br.com.bgdo.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.bgdo.personapi.dto.request.PersonDTO;
import br.com.bgdo.personapi.dto.response.MessageResponseDTO;
import br.com.bgdo.personapi.entity.Person;
import br.com.bgdo.personapi.exception.PersonNotFoundException;
import br.com.bgdo.personapi.mapper.PersonMapper;
import br.com.bgdo.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;
  private final PersonMapper personMapper;

  public MessageResponseDTO createPerson(PersonDTO person) {
    Person savedPerson = personRepository.save(personMapper.toModel(person));
    return createMessageResponse(savedPerson, "Person successfully created with ID ");
  }

  public List<PersonDTO> listAll() {
    List<Person> allPeople = personRepository.findAll();
    return allPeople.stream().map(dto -> personMapper.toDTO(dto)).collect(Collectors.toList());
  }

  public PersonDTO findById(Long id) throws PersonNotFoundException {
    Person person = verifyIfExists(id);
    return personMapper.toDTO(person);
  }

  public void delete(Long id) throws PersonNotFoundException {
    verifyIfExists(id);
    personRepository.deleteById(id);
  }

  public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
    verifyIfExists(id);
    Person updatedPerson = personRepository.save(personMapper.toModel(personDTO));
    return createMessageResponse(updatedPerson, "Person successfully updated with ID ");
  }
 
  private Person verifyIfExists(Long id) throws PersonNotFoundException {
    return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
  }

  private MessageResponseDTO createMessageResponse(Person person, String message) {
    return MessageResponseDTO.builder().message(message + person.getId()).build();
  }
}
