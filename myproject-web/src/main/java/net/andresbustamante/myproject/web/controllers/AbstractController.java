package net.andresbustamante.myproject.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class AbstractController {

    @Autowired
    protected ApplicationContext applicationContext;
}
