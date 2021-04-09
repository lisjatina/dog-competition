package com.example.dogcompetition.data;

import com.example.dogcompetition.dto.ParticipantDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionManager {

    private Course course;

    public void startCompetition(ParticipantDto participantDto, Integer length, Double speed){
        List <ParticipantDto> currentParticipants = getParticipants();
    course = new Course(length, speed);
    var standardTime = course.calculateStandardTime(); // надо записать значение в базу и отобразить в html
    var maxTime = course.calculateMaxTime(); // надо записать значение в базу и отобразить в html
    course.calculateResult(participantDto); // надо записать значение в базу и отобразить в html
    }

    public List <ParticipantDto> getParticipants(){
     // return list of participants (participants DTO?) with Hibernate connection
        return new ArrayList<>();
    }
}
