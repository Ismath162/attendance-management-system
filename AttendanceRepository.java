package com.attendance.attendancesystem.repository;

import com.attendance.attendancesystem.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudentNameContainingIgnoreCase(String name);

    List<Attendance> findByStatus(String status);

}