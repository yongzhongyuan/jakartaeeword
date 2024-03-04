package com.ordina.rest;

import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApplication extends Application {
	@Override
    public Set<Class<?>> getClasses() {
        return Set.of(WordFrequency.class);
    }

}