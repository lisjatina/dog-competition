package com.example.dogcompetition.controllers;

import com.example.dogcompetition.SessionData;
import com.example.dogcompetition.data.UserRepository;
import com.example.dogcompetition.dto.LoginDto;
import com.example.dogcompetition.dto.ParticipantDto;
import com.example.dogcompetition.dto.RegistrationDto;
import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.services.RegistrationManager;
import com.example.dogcompetition.services.ResultManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;


@Controller
public class MainController {

    @GetMapping ("/")
    public String getRegistrationPage(Model model){
        DatabaseManager dm = new DatabaseManager();

        model.addAttribute("breeds", dm.getBreeds());

        return "registration";
    }

    // Method for adding participants into database (so far incorrect)
    @PostMapping ("/register")
    public ModelAndView register(RegistrationDto rDto){
        var rm = new RegistrationManager();
        rm.saveParticipant(rDto);
        return new ModelAndView("redirect:/participants");
    }

    // Method for printing registered participants (Just name, surname and dog's pet name)
    // (so fas incorrect)
    @GetMapping("/participants")
    public String getListOfParticipants(Model model){
        var rm = new ResultManager();
        List <ParticipantDto> participants = rm.getParticipants();
        model.addAttribute("participants" , participants);

        return "list_of_participants";
    }

    @GetMapping("/results")
    public String getResults(Model model){
        var rm = new ResultManager();
        var results = rm.getResults();
        model.addAttribute("results", results);
        return "results";
    }

    @GetMapping("/login")
    public String getIndex(Model model) {
        model.addAttribute("error","");
        model.addAttribute("hasError", false);
        return "login";
    }
    //HttpSession session
    @PostMapping("/login")
    public String login(LoginDto userData, Model model, HttpServletRequest request) {

        var repo = new UserRepository();

        var time = LocalDateTime.parse(userData.getTime());

        var user = repo.login(userData.getEmail(), userData.getPwd());

        if(user == null) {
            model.addAttribute("error", "Unable to login");
            model.addAttribute("hasError", true);
            return "login";
        }

        request.getSession().setAttribute(SessionData.User, user);

        model.addAttribute("user", user);

        return "add_results";
    }
}
