package com.sml.leaveservice.repository;

import com.sml.leaveservice.dto.LeaveDTO;
import com.sml.leaveservice.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LeaveRepository extends JpaRepository<Leave, Long> {

    @Query(name = "SELECT ANNUAL_LEAVES, CASUAL_LEAVES, TOTAL_LEAVES, AVAILABLE_LEAVES FROM LEAVE WHERE FK_EMPLOYEE_ID = ?1", nativeQuery = true)
    LeaveDTO findLeavesByEmployeeId(Long id);
}
