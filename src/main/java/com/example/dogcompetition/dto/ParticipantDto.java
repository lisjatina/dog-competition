package com.example.dogcompetition.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// класс для отображения результатов на сайте
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {

    private String name;
    private String surname;
    private String dogPetName;
    private String dogFullName;
    private String dogBreed;
    private Double time;
    private Double speed;
    private Integer faults;
    private Double timeFaults;
    private Double totalFaults;
    private String disqualification;

}
