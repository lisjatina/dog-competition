package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    private String level;
    private Integer cleanRuns;

    // можно сделать метод void и просто выдавать сообщение, что участник может сменить класс

    public String changeLevelToA2(String level) {
        if (calculateCleanRuns() == 3) {
            level = "A2";
            System.out.println("The participant must change level to A2");
        }
        level = "A0";
        return level;
    }


    // Ox. comment - может cleanRuns надо прописать как метод, а не как переменную.
    // Т.е. если три раза выполняется метод cleanRuns (calculateTimePenalties == 0,
    // refusal == 0, calculateAllPenalties == 0, то срабатывает метод changeLevel.

    public Integer calculateCleanRuns() {
        Course course = new Course();
        for (int i = 0; i < 3; i++) {
            // метод из Course вызвать могу, но не могу передать значение
            // как (Double dogTime), так как в классе Level нет переменной dogTime.
        }
        return null; // пока что null, чтобы красным не подчёркивал
    }
}
