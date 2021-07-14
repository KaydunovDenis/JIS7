package com.github.kaydunovDenis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.intellij.lang.annotations.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {
    @Pattern("[A-Z][a-z]*")
    public String firstName;
    public String lastName;
    public Integer age;
}
