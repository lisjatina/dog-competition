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
public class Handler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "handler_id")
    private Integer id;
    @Column (name = "handler_name")
    private String name;
    @Column (name = "handler_surname")
    private String surname;
}
