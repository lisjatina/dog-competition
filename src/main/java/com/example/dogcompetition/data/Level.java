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
    public String changeLevel(String level){

        if (cleanRuns == 3){
            level = "A2";
        }
        level = "A0";
        return level;
    }
}
