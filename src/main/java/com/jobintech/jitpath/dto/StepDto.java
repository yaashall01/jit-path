package com.jobintech.jitpath.dto;

import com.jobintech.jitpath.enums.StepType;
import com.jobintech.jitpath.model.Curriculum;
import com.jobintech.jitpath.model.Task;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StepDto {

    private Long id;

    private String title;

    private String description;

    private StepType type;

    private Curriculum curriculum;

    private List<Task> tasks = new ArrayList<>();
}
