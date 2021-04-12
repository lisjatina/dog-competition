package com.example.dogcompetition.services;

import com.example.dogcompetition.data.Course;
import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.dto.ParticipantDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultManager {
    private Course course;

    public List<ParticipantDto> getParticipants() {
        var dm = new DatabaseManager();
        var dogs = dm.getDogs();
        return dogs.stream()
                .map(dog -> new ParticipantDto(dog.getId(),
                        dog.getHandler().getName(),
                        dog.getHandler().getSurname(),
                        dog.getPetName(),
                        dog.getPedigreeName(),
                        dog.getBreed()))
                .collect(Collectors.toList());
    }

    public List<ParticipantDto> getResults(Integer courseLenght, Double courseSpeed) {
        var dm = new DatabaseManager();
        var dogs = dm.getDogs();
        return dogs.stream()
                .map(dog -> new ParticipantDto(
                        dog.getId(),
                        dog.getHandler().getName(),
                        dog.getHandler().getSurname(),
                        dog.getPetName(),
                        dog.getPedigreeName(),
                        dog.getBreed(),
                        18.80,
                        0,
                        0,
                        "",
                        0.0,
                        0,
                        0.0,
                        0.0))
                .collect(Collectors.toList());
    }

    public void saveResult(ParticipantDto participantDto){

    }
}
