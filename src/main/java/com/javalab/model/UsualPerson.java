package com.javalab.model;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.Wither;
import org.springframework.stereotype.Component;

import java.util.List;

@Value
@Builder
public class UsualPerson implements Person {
    long id;
    String firstName;
    String lastName;
    Country country;
    int age;
    float height;
    boolean isProgrammer;

    @Wither
    boolean broke;

    @Singular
    List<Contact> contacts;
}
