package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class A3 extends Course {

@Override
//умножить на 1,5
public Double calculateMaxTime(Integer length, Double speed) {
    return length / speed;
}
}
