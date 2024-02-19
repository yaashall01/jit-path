package com.jobintech.jitpath.model;

import com.jobintech.jitpath.enums.StepType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "step")
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private StepType type;

    @OneToMany
    private List<Task> tasks;

}
