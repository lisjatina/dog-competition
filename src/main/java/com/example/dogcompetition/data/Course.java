package com.example.dogcompetition.data;

import com.example.dogcompetition.dto.ParticipantDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Integer length;
    private Double speed;

    // final version, correct
    public Double calculateStandardTime() {
        return length / speed;
    }

    // final version, correct
    public Double calculateMaxTime() {
        return (calculateStandardTime()* 2);
    }

    // final version, correct
    public Double calculateTimePenalties(Double dogTime) {
        if (dogTime > calculateStandardTime()) {
            return (dogTime - calculateStandardTime());
        } else {
            return 0d;
        }
    }

    public Integer calculatePenalties(Integer faults, Integer refusals){
    int mistake = 5;
    return (faults+refusals)*mistake;
    }

    // final version, correct
    public Boolean disqForExceedingTime(Double dogTime) {
        if (dogTime> calculateMaxTime()) {
            return true;
        }
        return false;
    }
    // final version, correct
    public Double calculateTotalPenalties(Integer faults, Integer refusals, Double dogTime) {
        if (calculateTimePenalties(dogTime) > 0) {
            return calculatePenalties(faults, refusals) + calculateTimePenalties(dogTime);
        } else {
            return (double)calculatePenalties(faults, refusals);
        }
    }
    // final version, correct
    public boolean disqForThreeRefusals(Integer refusal) {
        if (refusal >= 3) {
            return true;
        }
        return false;
    }

    // final version, correct
    public double calculateDogSpeed(Integer courseLength, Double dogTime){
        return courseLength/dogTime;
    }

    // final version, correct
    public boolean disqualified(String disq) {
        if (disq.equalsIgnoreCase("disq")) {
            return true;
        }
        return false;
    }

    //записывает в базу результаты участников (нужен метод, который
    // возвращает отсортированный по penalty и времени список участников). View из DB?
    public void calculateResult(ParticipantDto participantDto){
        if (disqForExceedingTime(participantDto.getTime()) || disqForThreeRefusals(participantDto.getRefusals())
                || disqualified(participantDto.getDisq())){
            participantDto.setTime(500.0);
            participantDto.setDisq("Disq");
            participantDto.setFaults(0);
            participantDto.setRefusals(0);
            participantDto.setSpeed(0.0);
            participantDto.setTimeFaults(0.0);
            participantDto.setTotalFaults(500.0);
        }
        else {
            var dogTime = participantDto.getTime();
            var refusals = participantDto.getRefusals();
            var faults = participantDto.getFaults();
            calculateDogSpeed(length,dogTime);
            var coursePenalties = calculatePenalties(faults, refusals);
            var timePenalties = calculateTimePenalties(dogTime);
            var totalPenalties = calculateTotalPenalties(faults, refusals, dogTime);
        }
    }
}
