package com.attendance.attendancesystem.service;

import com.attendance.attendancesystem.model.Attendance;
import com.attendance.attendancesystem.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository repository;

    public AttendanceService(AttendanceRepository repository) {
        this.repository = repository;
    }

    public Attendance addAttendance(Attendance attendance) {
        return repository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return repository.findAll();
    }

    public Attendance updateAttendance(Long id, Attendance newData) {

        Attendance attendance = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        attendance.setStudentName(newData.getStudentName());
        attendance.setRollNumber(newData.getRollNumber());
        attendance.setCourseName(newData.getCourseName());
        attendance.setAttendanceDate(newData.getAttendanceDate());
        attendance.setStatus(newData.getStatus());

        return repository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        repository.deleteById(id);
    }

    public List<Attendance> searchByName(String name) {
        return repository.findByStudentNameContainingIgnoreCase(name);
    }

    public List<Attendance> filterByStatus(String status) {
        return repository.findByStatus(status);
    }

}