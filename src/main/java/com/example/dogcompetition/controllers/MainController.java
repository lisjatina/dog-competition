package com.example.dogcompetition.controllers;

import com.example.dogcompetition.data.Participant;
import com.example.dogcompetition.dto.RegistrationDto;
import com.example.dogcompetition.managers.RegistrationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    @GetMapping ("/")
    public String getRegistrationPage(){

        return "registration";
    }

    // Method for adding participants into database (so fas incorrect)
    @PostMapping ("/")
    public ModelAndView register(@ModelAttribute("addParticipant") RegistrationDto rDto){
        var rm = new RegistrationManager();
        rm.save(rDto);
        return new ModelAndView("redirect:/list_of_participants");
    }

    // Method for printing registered participants (Just name, surname and dog's pet name)
    // (so fas incorrect)
    @GetMapping("/participants")
    public String getListOfParticipants(Model model){
        List <Participant> participants = new ArrayList<>();
        model.addAttribute("participants" , participants);

        return "list_of_participants";
    }
}
