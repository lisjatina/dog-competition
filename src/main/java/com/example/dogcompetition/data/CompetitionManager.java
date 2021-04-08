package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionManager {

    private Course course;



    public void startCompetition(){
    var standardTime = course.calculateStandardTime();
    var maxTime = course.calculateMaxTime();
    }



    public List <Handler> getParticipants(){
     // return list of participants (participants DTO?) with Hibernate connection
        return new ArrayList<>();
    }
}
