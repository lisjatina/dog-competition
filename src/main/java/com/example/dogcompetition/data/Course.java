package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Integer length;
    private Double dogTime;
    private Double speed;
    private Integer refusal; //если три отказа - disq
    private Integer mistake;
    private String disq;


    public Double calculateStandardTime(Integer length, Double speed) {
        return length / speed;
    }

    // ok - умножить на 2
    public Double calculateMaxTime(Integer length, Double speed) {
        return ((length / speed) * 2);
    }

    // ok - метод дисквал за превышение максимального времени
    public void calculateIsDogDisqualifiedForExceedingMaxTime(Integer length, Double speed) {
        if (dogTime > calculateMaxTime(length, speed)) {
            this.disq = "DISQ";
        }
    }

    // ok - может иметь отрицательное значение!
    // В случае, если значение меньше нуля, то не учитывается в подсчете штрафов
    // на трассе, иначе общее количество штрафов тоже получим отрицательное.
    public Double calculateTimePenalties(Double dogTime) {
        if (dogTime > calculateMaxTime(length, speed)) {
            return (dogTime - calculateMaxTime(length, speed));
        } else {
            return 0d;
        }
    }

    // ok - складываем штраф за время(если больше нуля)
    public Double calculateAllPenalties(Integer numberOfMistakes) {
        Double mistake = 5.0;
        if (calculateTimePenalties(dogTime) > 0) {
            return numberOfMistakes * mistake + calculateTimePenalties(dogTime);
        } else {
            return numberOfMistakes * mistake;
        }
    }

    // ok - собака снялась за три отказа
    public void disqualifiedForThreeRefusals(Integer refusal) {
        if (refusal == 3) {
            this.dogTime = null;
            this.disq = "DISQ";
        }
    }

    // ok - если собака снялась, убежав куда не надо
    public void disqualified() {
        if (getDogTime() == 500) {
            this.dogTime = null;
            this.disq = "DISQ";
        }
    }
}
