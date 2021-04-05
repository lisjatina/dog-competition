package com.example.dogcompetition.managers;

import com.example.dogcompetition.data.Course;
import com.example.dogcompetition.data.Course_A3;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionManager {

    private Course course;
    private Course_A3 courseA3;

    public void startCompetition(){
    var standardTime = course.calculateStandardTime();
    var maxTime = course.calculateMaxTime();
    }

    public void startA3(){courseA3.calculateStandardTime();
    }
}
