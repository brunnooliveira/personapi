package br.com.bgdo.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.bgdo.personapi.dto.request.PersonDTO;
import br.com.bgdo.personapi.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}
