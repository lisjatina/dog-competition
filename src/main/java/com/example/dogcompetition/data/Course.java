package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Integer length;
    private Double dogTime;
    private Double speed;
    private Integer refusal; //если три отказа - disq
    private Integer mistake;
    private String disq;

    //если собака снялась
    public void disqualified (Double time){
        if (getDogTime() == 500){
        this.dogTime = null;
        this.disq = "DISQ";
        }
    }

    //метод дисквал за превышение максимального времени

    public Double calculateStandardTime (Integer length, Double speed){
        return length/speed;
    }

    //умножить на 2
    public Double calculateMaxTime (Integer length, Double speed){
        return length/speed;
    }

    //умножить на 1,5
    public Double calculateMaxTimeA3 (Integer length, Double speed){
        return length/speed;
    }

    //время CACIAg - время самой быстрой собаки в ростовой категории *15%

}
