package com.javalab.model;

import lombok.Value;

@Value
public class UsualContact implements Contact {
    long id;
    String type;
    String value;
}
