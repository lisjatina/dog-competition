package com.example.dogcompetition;

import com.example.dogcompetition.data.Result;

import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void check_standard_time_calculation_equals(){
        Double expectedTime = (200/5.0);
        Result result = new Result();
        result.setCourseLength(200);
        result.setCourseSpeed(5.0);
        Assert.assertEquals(expectedTime,result.calculateAndGetStandardTime());
    }
    @Test
    public void check_standard_time_calculation_not_equals(){
        Double time = 41.0;
        Result result = new Result();
        result.setCourseLength(200);
        result.setCourseSpeed(5.0);
        Assert.assertNotEquals(time,result.calculateAndGetStandardTime());
    }
    @Test
    public void check_dog_time_calculation_equals(){
        Double dogTime = (200/4.0);
        Result result = new Result();
        result.setCourseLength(200);
        result.setTime(4.0);
        Assert.assertEquals(dogTime,result.calculateAndSetDogSpeed());
    }

    @Test
    public void check_calculate_mistake_equals(){
        Integer mistakes = ((2+3)*5);
        Result result = new Result();
        result.setFaults(3);
        result.setRefusals(2);
        Assert.assertEquals(mistakes,result.calcMistakes());
    }

    @Test
    public void check_calculate_time_faults_equals(){
        Double timeFaults = 10.0;
        Result result = new Result();
        result.setTime(50.0);
        result.setCourseLength(200);
        result.setCourseSpeed(5.0);
        Assert.assertEquals(timeFaults,result.calcAndSetTimeFaults());
    }

    @Test
    public void check_calculate_total_faults_equals(){
        Double totalFaults = ((2+3)*5) +10.0;
        Result result = new Result();
        result.setFaults(3);
        result.setRefusals(2);
        result.setTime(50.0);
        result.setCourseLength(200);
        result.setCourseSpeed(5.0);
        Assert.assertEquals(totalFaults,result.calcTotalFaults());
    }
}
