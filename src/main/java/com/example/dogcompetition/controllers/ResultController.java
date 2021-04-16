package com.example.dogcompetition.controllers;

import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.data.User;
import com.example.dogcompetition.dto.ResultDto;
import com.example.dogcompetition.services.ResultManager;
import com.example.dogcompetition.services.SessionData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ResultController {

    private DatabaseManager dm;

    public ResultController() {
        dm = new DatabaseManager();
    }

   // showing list of entered results in descending order (correct)
    @GetMapping("/results")
    public String getResults(Model model){
        model.addAttribute("agility0", dm.getSortedResultsForA0());
        model.addAttribute("agility1", dm.getSortedResultsForA1());
        model.addAttribute("agility2", dm.getSortedResultsForA2());
        model.addAttribute("agility3", dm.getSortedResultsForA3());
        return "results";
    }

   @PostMapping ("/results/update")
    public String updateResults(Model model, HttpSession session){
      var user = (User) session.getAttribute(SessionData.User);
       model.addAttribute("user", user);
//       model.addAttribute("sessionId", session.getId());
       model.addAttribute("results", dm.getResults());
        return  "update";
    }

    // should be Model And View with re-direct back to update page (/results/update)
    // this worked (incorrectly), commented for checking other
//    @PostMapping("/results/update/{id}")
//    public String updateResult(@PathVariable int id, Model model, ResultDto dto){
//        var rm = new ResultManager();
//        var updated = rm.updateResult(id, dto);
//        dm.updateResult(updated);
//        model.addAttribute("result", dm.getResults());
//        return "add_results";
//    }

    @PostMapping ("/results/update/{id}")
    public ModelAndView updateCurrentResult(@PathVariable int id, Model model, ResultDto dto){
    var rm = new ResultManager();
    var updated = rm.updateResult(id, dto);
    dm.updateResult(updated);
    model.addAttribute("result", dm.getResults());
    return new ModelAndView("redirect:/results/update");
    }

    // this is form for filling results
    @PostMapping("/results/update/add")
    public String addRes( Model model){

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
