package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Course_A3 extends Course {
    //private List <Participant> participants = new ArrayList<>();

    @Override
// ok - умножить на 1,5
    public Double calculateMaxTime(Integer length, Double speed) {
        return ((length / speed) * 1.5);
    }

    //время CACIAg - время самой быстрой собаки в ростовой категории *15% -
    // Ox. comment - тут, как я понимаю, надо идти по ArrayList результатов,
    // и искать minDogTime. Но где у нас ArrayList результатов?

}
