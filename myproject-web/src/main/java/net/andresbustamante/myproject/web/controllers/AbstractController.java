package net.andresbustamante.myproject.web.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

public abstract class AbstractController {

    @Autowired
    protected ApplicationContext applicationContext;

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    protected AbstractController(final ObjectMapper objectMapper, final HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.of(objectMapper);
    }

    public Optional<HttpServletRequest> getRequest() {
        return Optional.of(request);
    }
}
