package com.example.dogcompetition.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "handler")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "handler_id")
    private Integer id;
    @Column (name = "handler_name")
    private String name;
    @Column (name = "handler_surname")
    private String surname;

@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
@JoinColumn(name="handler_id", referencedColumnName = "dog_handler_id", nullable = true)
    private Dog dog;
}
