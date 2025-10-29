package com.donmaestro.barbearia.controller;

import com.donmaestro.barbearia.model.Appointment;
import com.donmaestro.barbearia.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {
    private final AppointmentService service;
    public AppointmentController(AppointmentService service){ this.service = service; }

    @GetMapping
    public List<Appointment> all(){ return service.findAll(); }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Appointment appointment){
        Appointment saved = service.save(appointment);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
