package br.com.bgdo.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bgdo.personapi.dto.response.MessageResponseDTO;
import br.com.bgdo.personapi.entity.Person;
import br.com.bgdo.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

  private final PersonRepository personRepository;

  @GetMapping
  public String getBookString() {
    return "API Test!";
  }

  @PostMapping
  public MessageResponseDTO createPerson(@RequestBody Person person) {
    Person savedPerson = personRepository.save(person);
    return MessageResponseDTO.builder().message("Created person with ID: " + savedPerson.getId()).build();
  }
}
