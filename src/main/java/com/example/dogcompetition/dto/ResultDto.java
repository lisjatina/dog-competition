package com.example.dogcompetition.dto;

import lombok.Data;

@Data

public class ResultDto {

    private Double dogTime;
    private Integer faults;
    private Integer refusals;
    private Double speed;
    private Integer length;

    public Double calculateDogSpeed(){

        return length/dogTime;
    }

    public Double calculateStandardTime(){
        return length/speed;
    }

    public Integer calcMistakes(){
        return   (faults+refusals)*5;
    }

    public Double calcTimeFaults(){
        if (dogTime>calculateStandardTime()){
            return  dogTime-calculateStandardTime();
        }else {
            return 0.0;
        }
    }

    public Double calcTotalFaults(){
        return  calcMistakes()+calcTimeFaults();
    }
}


