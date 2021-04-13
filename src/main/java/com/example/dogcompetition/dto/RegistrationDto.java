package com.example.dogcompetition.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


// класс для регистрации на соревнования на сайте
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegistrationDto {
    private Integer handlerId;
    private String hName;
    private String hSurname;
    private String email;

    private Integer dogId;
    private String dogFullName;
    private String dogPetName;
    private String dogBreed;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dogDateOfBirth;
    private String microchip;
    private String size;
    private String level;

}
