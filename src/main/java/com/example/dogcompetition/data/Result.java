package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "result_id")
    private Integer id;

    @Column (name = "time")
    private Double time;
    @Column (name = "faults")
    private Integer faults;
    @Column (name = "refusals")
    private Integer refusals;
    @Column (name = "disq")
    private String disq;
    @Column (name = "speed")
    private Double speed;
    @Column (name = "mistakes")
    private Integer mistakes;
    @Column (name = "time_faults")
    private Double timeFaults;
    @Column (name = "total_faults")
    private Double totalFaults;

    //the same for all dogs
    @Column(name = "course_length")
    private Integer courseLength;

    //the same for all dogs
    @Column(name = "course_speed")
    private Double courseSpeed;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name="dog_result_id", referencedColumnName = "dog_id", nullable = false)
    private Dog dog;

    private Double calculateMaxTime() {
        return (calculateAndGetStandardTime()* 2);
    }

    public Double calculateAndSetDogSpeed(){

        return this.speed = courseLength/time;
    }

    public Double calculateAndGetStandardTime(){
    return courseLength/courseSpeed;
    }

    public Integer calcMistakes(){
        return   this.mistakes = (faults+refusals)*5;
    }

    public Double calcAndSetTimeFaults(){
        if (time> calculateAndGetStandardTime()){
        return  this.timeFaults= time- calculateAndGetStandardTime();
        }else {
            return this.timeFaults=0.0;
        }
    }

    public Double calcTotalFaults(){
        return  this.totalFaults = calcMistakes()+ calcAndSetTimeFaults();
    }

    public Boolean disqForExceedingTime() {
        if (time> calculateMaxTime()) {
            return true;
        }
        return false;
    }

    public boolean disqForThreeRefusals() {
        if (refusals >= 3) {
            return true;
        }
        return false;
    }

    public boolean disqualified() {
        if (disq.equalsIgnoreCase("disq")) {
            return true;
        }
        return false;
    }

    public void dogIsDisqualified(){
        if(disqualified() || disqForThreeRefusals() || disqForExceedingTime()){
            this.time = 500.0;
            this.disq = "Disq";
            this.faults = 0;
            this.refusals = 0;
            this.speed = 0.0;
            this.timeFaults = 0.0;
            this.totalFaults = 500.0;
        }
    }
}
