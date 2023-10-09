package com.training.petru.jsonParser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

}
