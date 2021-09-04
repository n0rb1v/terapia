package com.example.terapia;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class PersonNotFoundException extends AbstractThrowableProblem {
    public PersonNotFoundException() {
        super(URI.create("person/not-found"),
                "Not found",
                Status.NOT_FOUND,
                "Not found");
    }
}
