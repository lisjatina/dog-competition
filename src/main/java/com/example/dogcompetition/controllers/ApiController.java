package com.example.dogcompetition.controllers;

import com.example.dogcompetition.data.DatabaseManager;
import com.example.dogcompetition.data.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ApiController {
    private DatabaseManager dm;
    public ApiController() {
        dm = new DatabaseManager();
    }

    // testing web API to get list of results
    @GetMapping("/res")
    public Iterable<Result> getResults() {
        return  dm.getResults();
    }
    // get result by ID
    @GetMapping("/res/{id}")
    public Result getResult(@PathVariable int id) {
        return dm.getResultById(id);
    }
    // saving result
    @PostMapping("/res")
    public Result addResult(@RequestBody Result result)
    {
        if(result == null) {
            return null;
        }
        dm.save(result);
        return result;
    }
    // update result by Id
    @PutMapping("/res/{id}")
    public Result updateOneResult(@RequestBody Result result, @PathVariable int id){
        if (result == null){
            return null;
        }
        if (id != result.getId()){
            return null;
        }
        dm.update(result);
        return result;
    }

    @DeleteMapping("/res/{id}")
    public void deleteResult(@PathVariable int id) {
        var result = dm.getResultById(id);
        if(result != null) {
            dm.delete(result);
        }
    }
}
