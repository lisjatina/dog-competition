package com.example.dogcompetition.services;

import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.data.Dog;
import com.example.dogcompetition.data.Handler;
import com.example.dogcompetition.data.Result;
import com.example.dogcompetition.dto.RegistrationDto;


import java.util.List;

public class RegistrationManager {

    public void saveParticipant2(RegistrationDto dto) {

        var handler = new Handler(dto.getHandlerId(), dto.getHName(), dto.getHSurname());
        var dog = new Dog(dto.getDogId(), dto.getDogFullName(), dto.getDogPetName(),
                dto.getDogDateOfBirth(), dto.getMicrochip(),
                dto.getSize(), dto.getLevel(), dto.getDogBreed(), handler);
        var result = new Result(null, null,null,null, "", null,
                null,null,null,null, null, dog);
        var dm = new DatabaseManager();
        dm.saveList(List.of(handler, dog, result));
    }

    public void saveParticipant(RegistrationDto dto) {

        var handler = new Handler(dto.getHandlerId(), dto.getHName(), dto.getHSurname());
        var dog = new Dog(dto.getDogId(), dto.getDogFullName(), dto.getDogPetName(),
                dto.getDogDateOfBirth(), dto.getMicrochip(),
                dto.getSize(), dto.getLevel(), dto.getDogBreed(), handler);
        var dm = new DatabaseManager();
        dm.saveList(List.of(handler, dog));
    }
}

