package br.com.bgdo.personapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bgdo.personapi.dto.response.MessageResponseDTO;
import br.com.bgdo.personapi.entity.Person;
import br.com.bgdo.personapi.service.PersonService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

  private final PersonService personService;

  @GetMapping
  public String getBookString() {
    return "API Test!";
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO createPerson(@RequestBody Person person) {
    return personService.createPerson(person);
  }
}
