package com.jobintech.jitpath.dto;

import com.jobintech.jitpath.enums.TaskStatus;
import com.jobintech.jitpath.model.Step;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private String title;

    private String description;

    private Step step;

    private TaskStatus status;

    private LocalDate dateOfSubmission;

}
