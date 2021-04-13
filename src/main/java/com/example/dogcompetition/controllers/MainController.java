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
//        DatabaseManager dm = new DatabaseManager();
//        model.addAttribute("breeds", dm.getBreeds());
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

    //sending result to DB via internet form so far incorrect
    @PostMapping("/results")
    public ModelAndView addResults(Model model){
        var dm = new DatabaseManager();
//        var rm = new ResultManager();
//        model.addAttribute("course", rm.createCourse());
        var blankResults = dm.getResults();
        model.addAttribute("blankResults", blankResults);
        for (var rst: blankResults
             ) {
            dm.updateResult(rst);
        }
        var updatedResults = dm.getResults();
        model.addAttribute("results", updatedResults);
        return new ModelAndView("redirect:/results") ;
    }

    // showing list of entered results
    @GetMapping("/results")
    public String getResults(Model model){
        var dm = new DatabaseManager();
        model.addAttribute("results", dm.getResults());
        return "results";
    }

    @GetMapping("/results/{id}")
    public String getDynamicResults(@PathVariable int id, Model model){
        var dm = new DatabaseManager();
        model.addAttribute("result", dm.getResultById(id));
        return "test";
    }




//    @GetMapping("/results")
//    public String getResults(Model model, Integer length, Double speed){
//        Course course = new Course(length, speed);
//        model.addAttribute("course", course);
//        var rm = new ResultManager();
//        var results = rm.getResults(course);
//        model.addAttribute("results", results);
//        return "results";
//    }


}
