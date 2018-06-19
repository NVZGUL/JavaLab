package com.javalab.model;

public interface Person {
    long getId();

    String getFirstName();

    String getLastName();

    Country getCountry();

    int getAge();

    float getHeight();

    boolean isProgrammer();

    boolean isBroke();

    Person withBroke(boolean broke);

    java.util.List<Contact> getContacts();

    default String getName() {
        return String.format("%s %s", getFirstName(), getLastName());
    }
}
