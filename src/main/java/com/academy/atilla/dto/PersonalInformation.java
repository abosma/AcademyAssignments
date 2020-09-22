package com.academy.atilla.dto;

import java.io.Serializable;

public class PersonalInformation implements Serializable {
    private final Long id;
    private final String name;
    private final int age;

    public PersonalInformation(long id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
