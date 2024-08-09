package org.proway.student.travel_manangement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "destiny")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destiny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    private String city;

    private String time_zone;
}
