package com.example.dogcompetition.services;

import com.example.dogcompetition.data.Breed;
import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.data.Dog;
import com.example.dogcompetition.data.Handler;
import com.example.dogcompetition.dto.RegistrationDto;


import java.util.List;

public class RegistrationManager {

    public void saveParticipant(RegistrationDto dto) {

//        var breed = new Breed (0, "collie");
        var handler = new Handler(dto.getHandlerId(), dto.getHName(), dto.getHSurname());
        var dog = new Dog(dto.getDogId(), dto.getDogFullName(), dto.getDogPetName(),
                dto.getDogDateOfBirth(), dto.getMicrochip(),
                dto.getSize(), dto.getLevel(), dto.getDogBreed(), handler);
        var dm = new DatabaseManager();
        dm.save(List.of(handler, dog));
    }
}

