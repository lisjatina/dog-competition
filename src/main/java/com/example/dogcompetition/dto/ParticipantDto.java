package com.example.dogcompetition.dto;


import com.example.dogcompetition.data.Breed;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// класс для отображения результатов на сайте
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ParticipantDto {

    private Integer dogId;
    private String name;
    private String surname;
    private String dogPetName;
    private String dogFullName;
    private String dogBreed;

    private Double time;
    private Integer faults;
    private Integer refusals;
    private String disq;

    private Double speed;
    private Integer mistakes;
    private Double timeFaults;
    private Double totalFaults;

    public ParticipantDto(Integer dogId, String name, String surname, String dogPetName, String dogFullName, String dogBreed) {
        this.dogId = dogId;
        this.name = name;
        this.surname = surname;
        this.dogPetName = dogPetName;
        this.dogFullName = dogFullName;
        this.dogBreed = dogBreed;
    }
}
