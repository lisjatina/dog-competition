package com.example.dogcompetition.controllers;
import com.example.dogcompetition.data.Result;
import com.example.dogcompetition.dto.RegistrationDto;
import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.services.RegistrationManager;
import com.example.dogcompetition.services.ResultManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @GetMapping ("/register")
    public String getRegistrationPage(){
        return "registration";
    }

    // Method for adding participants into database
    @PostMapping ("/register")
    public ModelAndView register(RegistrationDto rDto){
        var rm = new RegistrationManager();
        rm.saveParticipant2(rDto);
        return new ModelAndView("redirect:/participants");
    }

    // showing list of participants
    @GetMapping("/participants")
    public String getListOfParticipants(Model model){
        var dm = new DatabaseManager();
        model.addAttribute("participants", dm.getDogs());
        return "list_of_participants";
    }

    @GetMapping("/result")
    public String getIndex(){
        return "index";
    }


}
