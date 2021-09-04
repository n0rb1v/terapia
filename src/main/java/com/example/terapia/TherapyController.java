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
@RequestMapping("/api/therapy")
public class TherapyController {

    private final TherapyService therapyService;

    @GetMapping
    @Operation(summary = "list of ...")
    public List<TherapyDTO> listAll() {
        return therapyService.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "creates entity")
    @ApiResponse(responseCode = "201",description = "entity created")
    public TherapyDTO createEntity(@Valid @RequestBody CreateTherapyCommand command) {
        return therapyService.createEntity(command);
    }

    @PostMapping("/{id}/persons")
    @Operation(summary = "add person to therapy")
    public TherapyDTO addPerson(@PathVariable("id") long id, @Valid @RequestBody CreatePersonCommand command) {
        return therapyService.addPerson(command, id);
    }

    @GetMapping("/{id}")
    public TherapyDTO findTherapyById(@PathVariable("id") long id){
        return therapyService.findTherapyById(id);
    }

    @PutMapping("/{id}/persons")
    @Operation(summary = "remove person")
    public void removePerson(@PathVariable("id") long id, @Valid @RequestBody UpdateWithExistingPersonCommand command){
        therapyService.removePerson(command,id);
    }

}
