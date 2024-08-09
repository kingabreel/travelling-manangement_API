package org.proway.student.travel_manangement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy = "destiny")
    private List<Travel> viagens;
}
