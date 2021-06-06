package br.com.bgdo.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.bgdo.personapi.dto.request.PersonDTO;
import br.com.bgdo.personapi.dto.response.MessageResponseDTO;
import br.com.bgdo.personapi.entity.Person;
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

}
