package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "dog_id")
    private Integer id;
    @Column (name = "dog_pedigree_name")
    private String pedigreeName;
    @Column (name = "dog_pet_name")
    private String petName;
    @Column (name = "dog_breed")
    private String breed;
    @Column (name = "dog_date_of_birth")
    private LocalDate dateOfBirth;
    @Column (name = "dog_microchip")
    private String microchip;
    @Column (name = "dog_size")
    private String size;
    @Column (name = "dog_level")
    private String level;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name="dog_handler_id", referencedColumnName = "handler_id", nullable = false)
    private Handler handler;


    // время не у собаки в момент регистрации, а у DTO - участника соревнований?
    private Double time;
}
