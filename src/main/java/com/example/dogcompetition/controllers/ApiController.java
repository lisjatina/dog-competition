package com.example.dogcompetition.controllers;

import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.data.Result;
import com.example.dogcompetition.dto.CourseDto;
import com.example.dogcompetition.dto.ResultDto;
import com.example.dogcompetition.services.ResultManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ApiController {
    private DatabaseManager dm;
    public ApiController() {
        dm = new DatabaseManager();
    }

    // testing web API to get list of results
    @GetMapping("/results")
    public Iterable<Result> getResults() {
        return  dm.getResults();
    }
    // get result by ID
    @GetMapping("/results/{id}")
    public Result getResult(@PathVariable int id) {
        return dm.getResultById(id);
    }
    // saving result
    @PostMapping("/results")
    public Result addResult(@RequestBody Result result)
    {
        if(result == null) {
            return null;
        }
        dm.save(result);
        return result;
    }
/*
    GET /api/results
    GET /api/results/{id}
    GET /api/dogs
    GET /api/dogs/{id}
    POST /api/results   // add new result
    PUT /api/results/{id} // update result
    DELETE /api/results/{id} // delete result
  */
    // update result by Id
    @PutMapping("/results/{id}")
    public ResponseEntity<Void> updateOneResult(@RequestBody ResultDto dto, @PathVariable int id){
        if (dto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var rm = new ResultManager();
        rm.updateResult(id,dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // update all results
    @PutMapping("/results")
    public void setCourseData(@RequestBody CourseDto dto){
        var rm = new ResultManager();
        rm.setCourseDetails(dto);
    }

    @DeleteMapping("/results/{id}")
    public void deleteResult(@PathVariable int id) {
        var result = dm.getResultById(id);
        if(result != null) {
            dm.delete(result);
        }
    }
}
