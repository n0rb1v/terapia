package com.example.terapia;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    @Operation(summary = "list of persons")
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "creates a player")
    @ApiResponse(responseCode = "201",description = "movie created")
    public PersonDTO createPlayer(@Valid @RequestBody CreatePersonCommand command) {
        return personService.createPerson(command);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete person")
    public void delete(@PathVariable("id") long id) {
        personService.deleteById(id);
    }
}
