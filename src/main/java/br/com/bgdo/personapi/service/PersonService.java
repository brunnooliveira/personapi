package br.com.bgdo.personapi.service;

import java.util.List;
import java.util.Optional;
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

  public MessageResponseDTO createPerson(PersonDTO person) {
    Person savedPerson = personRepository.save(PersonMapper.INSTANCE.toModel(person));
    return MessageResponseDTO.builder().message("Created person with ID: " + savedPerson.getId()).build();
  }

  public List<PersonDTO> listAll() {
    List<Person> allPeople = personRepository.findAll();

    return allPeople.stream()
            .map(dto -> PersonMapper.INSTANCE.toDTO(dto))
            .collect(Collectors.toList());
  }

  public PersonDTO findById(Long id) throws PersonNotFoundException {
    Person person = verifyIfExists(id);
    return PersonMapper.INSTANCE.toDTO(person);
  }

  public void delete(Long id) throws PersonNotFoundException {
    verifyIfExists(id);
    personRepository.deleteById(id);
  }

  private Person verifyIfExists(Long id) throws PersonNotFoundException {
    return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
  }

}
