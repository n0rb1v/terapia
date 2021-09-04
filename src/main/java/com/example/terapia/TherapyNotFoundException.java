package com.example.terapia;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class TherapyNotFoundException extends AbstractThrowableProblem {
    public TherapyNotFoundException() {
        super(URI.create("therapy/not-found"),
                "Not found",
                Status.NOT_FOUND,
                "Team not found");
    }
}
