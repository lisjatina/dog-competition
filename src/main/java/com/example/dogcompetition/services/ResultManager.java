package com.example.dogcompetition.services;

import com.example.dogcompetition.data.*;
import com.example.dogcompetition.dto.ParticipantDto;
import com.example.dogcompetition.dto.RegistrationDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultManager {

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

    public void saveResults(ParticipantDto dto, Integer id) {
            var dm = new DatabaseManager();
     var dog = dm.getById(id);
        var result = new Result(
                dto.getRunId(),
                dto.getTime(),
                dto.getFaults(),
                dto.getRefusals(),
                dto.getDisq(),
                dto.getSpeed(),
                dto.getMistakes(),
                dto.getTimeFaults(),
                dto.getTotalFaults(),
                dog);

        dm.save(List.of(result));
    }
//
//    public void saveResult(ParticipantDto dto, Integer length, Double speed){
//        var dm = new DatabaseManager();
//        Course course = new Course(length, speed);
//        course.calculateResult(dto);
//        dm.save();
////        var dogTime = dto.getTime();
////        var dogFaults = dto.getFaults();
////        var dogRefusals = dto.getRefusals()
////        var result = new Result(
////                dto.getDogId(),
////                dto.getTime(),
////                dto.getFaults(),
////                dto.getRefusals(),
////                dto.getDisq(),
////                course.calculateDogSpeed(length,dto.getTime()),
////                course.calculatePenalties(dto.getFaults(), dto.getRefusals()),
////                course.calculateTimePenalties(dto.getTime()),
////                course.calculateTotalPenalties(dto.getFaults(),dto.getRefusals(),dto.getTime()));
//    }

    public void saveParticipant(RegistrationDto dto) {

        var handler = new Handler(dto.getHandlerId(), dto.getHName(), dto.getHSurname());
        var dog = new Dog(dto.getDogId(), dto.getDogFullName(), dto.getDogPetName(),
                dto.getDogDateOfBirth(), dto.getMicrochip(),
                dto.getSize(), dto.getLevel(), dto.getDogBreed(),handler);
        var dm = new DatabaseManager();
        dm.save(List.of(handler, dog));
    }



    public List<ParticipantDto> getResults(Course course) {
        var dm = new DatabaseManager();
        var results = dm.getResults(); // all zero values should be taken from this list by dog Id
        return results.stream()
                .map(result -> new ParticipantDto(
                        result.getId(),
                        result.getDog().getId(),
                        result.getDog().getHandler().getName(),
                        result.getDog().getHandler().getSurname(),
                        result.getDog().getPetName(),
                        result.getDog().getPedigreeName(),
                        result.getDog().getBreed(),
                        result.getTime(),
                        result.getFaults(),
                        result.getRefusals(),
                        result.getDisq(),
                        result.calculateSpeed(course),
                        result.calcMistakes(course),
                        result.calcTimeFaults(course),
                        result.calcTotalFaults(course)))
                .collect(Collectors.toList());
    }


//        var something =  dogs.stream()
//                .map(dog -> new ParticipantDto(
//                        dog.getId(),
//
//                        dog.getHandler().getName(),
//                        dog.getHandler().getSurname(),
//                        dog.getPetName(),
//                        dog.getPedigreeName(),
//                        dog.getBreed(),
//                        0.0,
//                        0,
//                        0,
//                        "0",
//                        0.0,
//                        0,
//                        0.0,
//                        0.0))
//                .collect(Collectors.toList());
//    }
}
