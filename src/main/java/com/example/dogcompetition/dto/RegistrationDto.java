package com.example.dogcompetition.dto;

import com.example.dogcompetition.data.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// класс для регистрации на соревнования на сайте
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    private String hName;
    private String hSurname;
    private String dogFullName;
    private String dogPetName;
    private String dogBreed;
    private LocalDate dogDateOfBirth;
    private String microchip;
    private String size;
    private String email;

    //возможно для начала поменять на стринг
    private Level level;
}