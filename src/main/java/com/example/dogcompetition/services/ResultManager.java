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
        result.calculateDogSpeed();
        result.calcMistakes();
        result.calcTimeFaults();
        result.calcTotalFaults();
        dm.updateResult(result);
        return result;
    }
}
