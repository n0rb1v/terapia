package com.example.terapia;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class IllegalPersonStateException extends AbstractThrowableProblem {
    public IllegalPersonStateException() {
        super(URI.create("person/not-found"),
                "Not found",
                Status.BAD_REQUEST,
                "Person not on therapy");
    }
}
