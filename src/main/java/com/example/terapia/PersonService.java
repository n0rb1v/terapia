package com.example.terapia;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    public List<PersonDTO> listAll() {
        return personRepository.findAll().stream()
                .map(p -> modelMapper.map(p,PersonDTO.class))
                .collect(Collectors.toList());
    }

    public PersonDTO createPerson(CreatePersonCommand command) {
        Person person = new Person(
                command.getName());
        personRepository.save(person);
        return modelMapper.map(person,PersonDTO.class);
    }

    public void deleteById(long id) {
        personRepository.deleteById(id);
    }
}
