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

    // может иметь отрицательное значение! В случае, если значение меньше нуля, то не учитывается в подсчете штрафов
    //на трассе, иначе общее количество штрафов тоже получим отрицательное
    public Double calculateTimePenalties(Double dogTime) {
return null;
    }

    //складываем штраф за время(если больше нуля)
    public Double calculateAllPenalties(Integer numberOfMistakes) {
        Double mistake = 5.0;
        if (calculateTimePenalties(dogTime) > 0) {
            return numberOfMistakes * mistake + calculateTimePenalties(dogTime);
        } else {
            return numberOfMistakes * mistake;
        }
    }

    //если собака снялась
    public void disqualified(Double time) {
        if (getDogTime() == 500) {
            this.dogTime = null;
            this.disq = "DISQ";
        }
    }

    //метод дисквал за превышение максимального времени

    public Double calculateStandardTime(Integer length, Double speed) {
        return length / speed;
    }

    //умножить на 2
    public Double calculateMaxTime(Integer length, Double speed) {
        return length / speed;
    }



    //время CACIAg - время самой быстрой собаки в ростовой категории *15%

}
