package com.javalab.model;

public interface Country {
    long getId();
    Country setId(long id);

    Country setName(String name);
    String getName();

    String getCodeName();
    Country setCodeName(String codeName);
}
