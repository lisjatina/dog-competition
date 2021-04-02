package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class A3 {
    private Integer length;
    private Double dogTime;
    private Double speed;
    private Integer refusal; //если три отказа - disq
    private Integer mistake;
    private String disq;
}
