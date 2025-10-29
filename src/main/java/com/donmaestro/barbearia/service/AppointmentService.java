package com.donmaestro.barbearia.service;

import com.donmaestro.barbearia.model.Appointment;
import com.donmaestro.barbearia.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository repo;
    public AppointmentService(AppointmentRepository repo){ this.repo = repo; }

    public Appointment save(Appointment a){ return repo.save(a); }
    public List<Appointment> findAll(){ return repo.findAll(); }
    public void deleteById(Long id){ repo.deleteById(id); }
}
