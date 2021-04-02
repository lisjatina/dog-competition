package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition {

    private Course course;
    public void startCompetition(){
    course.calculateStandardTime(200,3.6);
    }
}
