package com.example.dogcompetition.dto;


import lombok.Data;


// класс для отображения результатов на сайте
@Data

public class ParticipantDto {

    private String name;
    private String surname;
    private String dogPetName;
    private String dogFullName;
    private String dogBreed;
    private Double time;
    private Double speed;
    private Integer faults;
    private Integer refusals;
    private Double timeFaults;
    private Double totalFaults;
    private String disq;

}
