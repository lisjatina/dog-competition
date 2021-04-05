package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    private Integer id;
    private String name;
    private String surname;

@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
//    @JoinColumn(name="owner_id", referencedColumnName = "id", nullable = true)
    private Dog dog;
}
