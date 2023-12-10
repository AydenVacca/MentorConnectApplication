package com.webapp.mentorconnect2.repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.mentorconnect2.models.Appointment;

public interface Appointment extends CrudRepository<Appointment, Long>{
    
}
