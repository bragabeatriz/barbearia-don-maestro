package com.donmaestro.barbearia.config;

import com.donmaestro.barbearia.model.Appointment;
import com.donmaestro.barbearia.repository.AppointmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner init(AppointmentRepository repo){
        return args -> {
            Appointment a = new Appointment();
            a.setClientName("João Silva");
            a.setService("Corte clássico");
            a.setPhone("+55 11 99999-0000");
            a.setAppointmentAt(LocalDateTime.now().plusDays(1).withHour(10).withMinute(0).withSecond(0).withNano(0));
            a.setNotes("Prefere máquina 2");
            repo.save(a);
        };
    }
}
