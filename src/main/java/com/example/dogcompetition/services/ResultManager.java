package com.example.dogcompetition.services;

import com.example.dogcompetition.data.*;
import com.example.dogcompetition.dto.ResultDto;


public class ResultManager {

    public Result updateResult(Integer id, ResultDto dto) {
        var dm = new DatabaseManager();
        var result = dm.getResultById(id);

            result.setCourseLength(dto.getLength());
            result.setCourseSpeed(dto.getSpeed());
            result.setTime(dto.getDogTime());
            result.setRefusals(dto.getRefusals());
            result.setFaults(dto.getFaults());
            result.setDisq(dto.getDisq());
        if(result.disqForExceedingTime() || result.disqualified() || result.disqForThreeRefusals()){
            result.setTime(500.0);
            result.setRefusals(0);
            result.setFaults(0);
            result.setSpeed(0.0);
            result.setMistakes(0);
            result.setTimeFaults(0.0);
            result.setTotalFaults(500.0);
            result.setDisq("DISQ");
        }
        else {
            result.calculateAndSetDogSpeed();
            result.calcMistakes();
            result.calcAndSetTimeFaults();
            result.calcTotalFaults();
        }
            dm.updateResult(result);
            return result;
    }

    public Result updateResult1(Integer id, ResultDto dto) {
        var dm = new DatabaseManager();
        var result = dm.getResultById(id);
        if(result.disqForExceedingTime() || result.disqualified()){
            result.setCourseLength(dto.getLength());
            result.setCourseSpeed(dto.getSpeed());
            result.setTime(500.0);
            result.setRefusals(0);
            result.setFaults(0);
            result.setSpeed(0.0);
            result.setMistakes(0);
            result.setTimeFaults(0.0);
            result.setTotalFaults(500.0);

        }else {
            result.setCourseLength(dto.getLength());
            result.setCourseSpeed(dto.getSpeed());
            result.setTime(dto.getDogTime());
            result.setRefusals(dto.getRefusals());
            result.setFaults(dto.getFaults());
            result.calculateAndSetDogSpeed();
            result.calcMistakes();
            result.calcAndSetTimeFaults();
            result.calcTotalFaults();
        }
        dm.updateResult(result);
        return result;
    }
}
