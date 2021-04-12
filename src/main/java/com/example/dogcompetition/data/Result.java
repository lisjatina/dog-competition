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

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name="dog_result_id", referencedColumnName = "dog_id", nullable = false)
    private Dog dog;

    public Double calculateSpeed(Course course){
    this.speed = course.calculateDogSpeed(course.getLength(), course.getSpeed());
    return speed;
    }

    public Integer calcMistakes(Course course){
        this.mistakes = course.calculatePenalties(getFaults(),getRefusals());
        return mistakes;
    }

    public Double calcTimeFaults(Course course){
        this.timeFaults= course.calculateTimePenalties(getTime());
        return timeFaults;
    }

    public Double calcTotalFaults(Course course){
        this.totalFaults = course.calculateTotalPenalties(getFaults(), getRefusals(), getTime());
        return totalFaults;
    }
}
