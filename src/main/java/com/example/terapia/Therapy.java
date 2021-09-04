package com.example.terapia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "therapy")
public class Therapy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String terapeuta;
    private String place;
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "therapy", cascade = CascadeType.ALL)
    private List<Person> persons;

    public void addPerson(Person person) {
        persons.add(person);
        person.setTherapy(this);
    }

    public void removePerson(Person person) {
        persons.remove(person);
        person.setTherapy(null);
    }

    public Therapy(String terapeuta, String place, LocalDateTime dateTime) {
        this.terapeuta = terapeuta;
        this.place = place;
        this.dateTime = dateTime;
    }
}
