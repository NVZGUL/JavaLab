package com.javalab.model;

import lombok.Value;

@Value
public class UsualCountry implements Country {
    String name;
    String codeName;
}
