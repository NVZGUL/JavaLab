package com.javalab.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UsualPersonTest {

    static String APPLICATION_CONTEXT_FILE = "ioc.xml";

    BeanFactory context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_FILE);

    @Test
    @DisplayName("Spring is start")
    void simpleTest() {
        assertEquals(getExpectedPerson(), context.getBean("person"));
    }

    private Person getExpectedPerson() {
        return UsualPerson.builder()
                .id(1l)
                .firstName("John")
                .lastName("Smith")
                .age(35)
                .isProgrammer(true)
                .height(1.78f)
                .broke(false)
                .country(new UsualCountry(1l,"Russia", "RU"))
                .contact(new UsualContact(1,"EMAIL", "test@email.com"))
                .contact(new UsualContact(2,"TELEPHONE", "+1 (111) 111-11-11"))
                .build();
    }
}