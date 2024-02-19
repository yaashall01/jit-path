package com.jobintech.jitpath.model;


import com.jobintech.jitpath.enums.CurriculumStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curriculum")
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String description;

    private LocalDate createdAt;

    private int durationInDays;

    @Enumerated(EnumType.STRING)
    private CurriculumStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    private Expert expert;

    @OneToMany
    private List<Step> steps;

}
