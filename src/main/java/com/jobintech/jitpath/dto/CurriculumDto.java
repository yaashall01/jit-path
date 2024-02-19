package com.jobintech.jitpath.dto;


import com.jobintech.jitpath.enums.CurriculumStatus;
import com.jobintech.jitpath.model.Expert;
import com.jobintech.jitpath.model.Step;
import com.jobintech.jitpath.model.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumDto {

    private String title;

    private String description;

    private LocalDate createdAt;

    private int durationInDays;

    private CurriculumStatus curriculumStatus;

    private ExpertDto expert;

    private List<Step> steps;
}
