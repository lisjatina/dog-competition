package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    private Integer id;
    private String pedigreeName;
    private String petName;
    private String breed;
    private LocalDate dateOfBirth;
    private String microchip;
    private String size;
    private Double time;
    //возможно для начала поменять на стринг
    private String level;


}
