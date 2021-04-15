package com.example.dogcompetition.controllers;

import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.data.User;
import com.example.dogcompetition.dto.ResultDto;
import com.example.dogcompetition.services.ResultManager;
import com.example.dogcompetition.services.SessionData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ResultController {

   // showing list of entered results in descending order (correct)
    @GetMapping("/results")
    public String getResults(Model model){
        var dm = new DatabaseManager();
        model.addAttribute("results", dm.getSortedResults());
        return "results";
    }

   @GetMapping("/results/update")
    public String updateResults(Model model, HttpSession session){
       var dm = new DatabaseManager();
       var user = (User) session.getAttribute(SessionData.User);
       model.addAttribute("user", user);
       model.addAttribute("sessionId", session.getId());
       model.addAttribute("results", dm.getResults());
        return  "update";
    }

    // without web API
    @PostMapping("/results/update/{id}")
    public String updateResult(@PathVariable int id, Model model, ResultDto dto){
        var rm = new ResultManager();
        var updated = rm.updateResult(id, dto);
        model.addAttribute("result", updated);
        return "add_results";
    }


//    @GetMapping("/results/update/")
//    public ModelAndView updateCurrentResult(@RequestParam int id, ResultDto dto){
//        var dm = new DatabaseManager();
//        dm.update(dto);
//        return new ModelAndView("redirect:/results/update");
//    }



//    @PostMapping("/add_garden")
//    public ModelAndView saveGarden(@ModelAttribute("addGardenData") GardenDTO gDto, Model model, HttpSession session) {
//        var user = (User) session.getAttribute(SessionData.User);
//
//        Plant plant = null;
//
//        var res = dmp.getPlants().stream()
//                .filter(p -> p.getId() == gDto.getUPlantId())
//                .findFirst();
//
//        if (res.isPresent()) {
//            plant = res.get();
//        }
//        if (plant != null) {
//            gDto.setUPlantId(plant.getId());
//        }
//
//        var gardenToAdd = new Garden(0, user.getId(), Date.valueOf(LocalDate.now()), plant);
//        dmg.addGarden(gardenToAdd);
//
//        model.addAttribute("plant", plant);
//        model.addAttribute("garden", gardenToAdd);
//        model.addAttribute("GardenDTO", gDto);
//
//        return new ModelAndView("redirect:/your_garden");
//    }

}
