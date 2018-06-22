package com.javalab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component("country")
public class UsualCountry implements Country {
    long id;
    String name;
    String codeName;

    public UsualCountry setId(long id) {
        this.id = id;
        return this;
    }

    public UsualCountry setName(String name) {
        this.name = name;
        return this;
    }

    public UsualCountry setCodeName(String codeName) {
        this.codeName = codeName;
        return this;
    }
}
