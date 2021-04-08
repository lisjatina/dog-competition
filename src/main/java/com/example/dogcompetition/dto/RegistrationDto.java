package com.example.dogcompetition.dto;


import lombok.Data;


import java.time.LocalDate;

// класс для регистрации на соревнования на сайте
@Data

public class RegistrationDto {
    private Integer handlerId;
    private String hName;
    private String hSurname;
    private String email;

    private Integer dogId;
    private String dogFullName;
    private String dogPetName;
    private String dogBreed;
    private LocalDate dogDateOfBirth;
    private String microchip;
    private String size;
    private String level;

}
