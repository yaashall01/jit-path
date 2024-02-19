package com.jobintech.jitpath.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpertDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate dob;
    private LocalDate dateOfRegistration;
    private LocalDate lastLogin;

}
