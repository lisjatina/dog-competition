package com.example.dogcompetition.services;

import com.example.dogcompetition.data.Breed;
import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.data.Dog;
import com.example.dogcompetition.data.Handler;
import com.example.dogcompetition.dto.RegistrationDto;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import java.util.List;

public class RegistrationManager {

    public void saveParticipant(RegistrationDto dto) {

        var breed = new Breed(1, "collie"); // TODO: 4/10/2021 получить breed из базы данных
        var handler = new Handler(dto.getHandlerId(), dto.getHName(), dto.getHSurname());
        var dog = new Dog(dto.getDogId(), dto.getDogFullName(), dto.getDogPetName(),
                dto.getDogDateOfBirth(), dto.getMicrochip(),
                dto.getSize(), dto.getLevel(), breed, handler);
        var dm = new DatabaseManager();
        dm.save(List.of(handler, dog));
    }
}

