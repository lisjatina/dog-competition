package com.example.dogcompetition.services;

import com.example.dogcompetition.data.*;
import com.example.dogcompetition.dto.CourseDto;
import com.example.dogcompetition.dto.ResultDto;


public class ResultManager {

    public Result updateResult(Integer id, ResultDto dto) {
        var dm = new DatabaseManager();
        var result = dm.getResultById(id);

//            result.setCourseLength(dto.getLength());
//            result.setCourseSpeed(dto.getSpeed());
            result.setTime(dto.getDogTime());
            result.setRefusals(dto.getRefusals());
            result.setFaults(dto.getFaults());
            result.setDisq(dto.getDisq());
        if(result.disqForExceedingTime() || result.disqualified() || result.disqForThreeRefusals()){
            result.setTime(500.0);
            result.setRefusals(null);
            result.setFaults(null);
            result.setSpeed(null);
            result.setMistakes(null);
            result.setTimeFaults(null);
            result.setTotalFaults(500.0);
            result.setDisq("DISQ");
        }else if(result.dogIsAbsent()){
            result.setTime(500.0);
            result.setRefusals(null);
            result.setFaults(null);
            result.setSpeed(null);
            result.setMistakes(null);
            result.setTimeFaults(null);
            result.setTotalFaults(500.0);
            result.setDisq("DNS");
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

    public void setCourseDetails(CourseDto courseDto){
        var dm = new DatabaseManager();

        for (var result:
                dm.getResults()) {
        result.setCourseSpeed(courseDto.getCourseSpeed());
        result.setCourseLength(courseDto.getCourseLength());
        dm.updateResult(result);
        }
    }
}
