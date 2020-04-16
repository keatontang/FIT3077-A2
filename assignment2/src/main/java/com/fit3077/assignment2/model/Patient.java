package com.fit3077.assignment2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * POJO
 */
public class Patient {
    private final UUID id;
    private final String name;

    /**
     * @JsonProperty: tells Spring to take the correct properties from JSON
     */
    public Patient(@JsonProperty("id") UUID id,
                   @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
