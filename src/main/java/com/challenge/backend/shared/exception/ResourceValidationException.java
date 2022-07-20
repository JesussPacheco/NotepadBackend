package com.challenge.backend.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ResourceValidationException extends RuntimeException {
    public ResourceValidationException() {
        super();
    }

    public ResourceValidationException(String message) {
        super(message);
    }

    public ResourceValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public <T> ResourceValidationException(String resourceName, Set<ConstraintViolation<T>> violations) {
        super(String.format("Not all constraints satisfied for %s: %s", resourceName,
                violations.stream().map(violation -> String.format("%s %s", violation.getPropertyPath(), violation.getMessage()))
                        .collect(Collectors.joining(". "))));
    }

    public ResourceValidationException(String resourceName, String message) {
        super(String.format("No all constraints satisfied for %s: %s", resourceName, message));
    }
}