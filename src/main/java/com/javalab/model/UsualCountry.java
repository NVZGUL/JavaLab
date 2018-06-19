package com.javalab.model;

import lombok.Value;
import org.springframework.stereotype.Component;

@Value
@Component("country")
public class UsualCountry implements Country {
    long id;
    String name;
    String codeName;
}
