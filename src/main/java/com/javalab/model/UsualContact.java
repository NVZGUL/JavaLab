package com.javalab.model;

import lombok.Value;

@Value
public class UsualContact implements Contact {
    String type;
    String value;
}
