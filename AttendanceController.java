package com.attendance.attendancesystem.controller;

import com.attendance.attendancesystem.model.Attendance;
import com.attendance.attendancesystem.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @PostMapping
    public Attendance addAttendance(@RequestBody Attendance attendance) {
        return service.addAttendance(attendance);
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return service.getAllAttendance();
    }

    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        return service.updateAttendance(id, attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        service.deleteAttendance(id);
    }

    @GetMapping("/search/{name}")
    public List<Attendance> searchByName(@PathVariable String name) {
        return service.searchByName(name);
    }

    @GetMapping("/status/{status}")
    public List<Attendance> filterByStatus(@PathVariable String status) {
        return service.filterByStatus(status);
    }
}