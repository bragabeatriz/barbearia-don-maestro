package com.donmaestro.barbearia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String clientName;

    @NotBlank
    private String service;

    @NotBlank
    private String phone;

    @Future
    private LocalDateTime appointmentAt;

    private String notes;

    // getters and setters
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getClientName(){return clientName;}
    public void setClientName(String clientName){this.clientName = clientName;}
    public String getService(){return service;}
    public void setService(String service){this.service = service;}
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}
    public LocalDateTime getAppointmentAt(){return appointmentAt;}
    public void setAppointmentAt(LocalDateTime appointmentAt){this.appointmentAt = appointmentAt;}
    public String getNotes(){return notes;}
    public void setNotes(String notes){this.notes = notes;}
}
