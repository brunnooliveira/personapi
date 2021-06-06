package br.com.bgdo.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bgdo.personapi.dto.request.PersonDTO;
import br.com.bgdo.personapi.dto.response.MessageResponseDTO;
import br.com.bgdo.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

  private final PersonService personService;

  @GetMapping
  public List<PersonDTO> getPersons() {
      return personService.listAll();
  }
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO person) {
    return personService.createPerson(person);
  }

  
}
