package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition {

    private Course course;
    private Course_A3 courseA3;

    public void startCompetition(){
    var standardTime = course.calculateStandardTime();
    var maxTime = course.calculateMaxTime();
    }

    public void startA3(){courseA3.calculateStandardTime();
    }
}
