package com.javalab.model;

import org.springframework.stereotype.Component;

@Component("bar")
public class ApuBar implements Bar {

    @Override
    public Squishee sellSquishee(Person person)  {
        if (person.isBroke()){
            throw new PersonBrokenException();
        }
        System.out.println("Here is your Squishee \n");
        return new Squishee("Usual Squishee");
    }
}
