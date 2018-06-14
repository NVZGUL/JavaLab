package com.javalab.model;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Value
@Builder
@Component("person")
public class UsualPerson implements Person {
    int id;
    String firstName;
    String lastName;
    //Country country;
    int age;
    float height;
    boolean isProgrammer;
    boolean broke;
    //@Singular
    //List<Contact> contacts;
}
