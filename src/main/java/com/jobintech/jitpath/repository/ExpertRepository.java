package com.jobintech.jitpath.repository;

import com.jobintech.jitpath.dto.ExpertDto;
import com.jobintech.jitpath.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpertRepository extends JpaRepository<Expert, Long> {
    Optional<Expert> findByEmailOrPhoneNumber(String email, String phoneNumber);
}
