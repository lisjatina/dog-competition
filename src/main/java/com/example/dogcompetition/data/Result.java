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

    public Double calculateDogSpeed(){

        return this.speed = courseLength/time;
    }

    public Double calculateStandardTime(){
    return courseLength/courseSpeed;
    }

    public Integer calcMistakes(){
        return   this.mistakes = (faults+refusals)*5;
    }

    public Double calcTimeFaults(){
        if (time>calculateStandardTime()){
        return  this.timeFaults= time-calculateStandardTime();
        }else {
            return this.timeFaults=0.0;
        }
    }

    public Double calcTotalFaults(){
        return  this.totalFaults = calcMistakes()+calcTimeFaults();
    }
}
