package com.example.terapia;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TherapyService {

    private final TherapyRepository therapyRepository;
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    public List<TherapyDTO> listAll() {
        return therapyRepository.findAll().stream()
                .map(team -> modelMapper.map(team, TherapyDTO.class))
                .collect(Collectors.toList());
    }

    public TherapyDTO createEntity(CreateTherapyCommand command) {
        Therapy therapy = new Therapy(
                command.getTerapeuta(),
                command.getPlace(),
                command.getDateTime());
        therapyRepository.save(therapy);
        return modelMapper.map(therapy, TherapyDTO.class);
    }

    @Transactional
    public TherapyDTO addPerson(CreatePersonCommand command, long id) {
        Therapy therapy = therapyRepository.findById(id).orElseThrow(() -> new TherapyNotFoundException());
        Person person = new Person(
                command.getName());
        therapy.addPerson(person);
        return modelMapper.map(therapy, TherapyDTO.class);
    }

    public TherapyDTO findTherapyById(long id) {
        Therapy therapy = therapyRepository.findById(id).orElseThrow(() -> new TherapyNotFoundException());
        return modelMapper.map(therapy, TherapyDTO.class);
    }

    @Transactional
    public void removePerson(UpdateWithExistingPersonCommand command, long id) {
        Therapy therapy = therapyRepository.findById(id).orElseThrow(() -> new TherapyNotFoundException());
        Person person = personRepository.findById(command.getId()).orElseThrow(() -> new PersonNotFoundException());
        if (!therapy.getPersons().contains(person)) {
            throw new IllegalPersonStateException();
        }
        therapy.removePerson(person);

    }
}
