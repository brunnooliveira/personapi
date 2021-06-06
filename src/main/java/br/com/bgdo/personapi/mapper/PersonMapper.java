package br.com.bgdo.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.bgdo.personapi.dto.request.PersonDTO;
import br.com.bgdo.personapi.entity.Person;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {
  public static final PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
  public abstract Person toModel(PersonDTO dto);

  public abstract PersonDTO toDTO(Person dto);
}
