package com.webapp.mentorconnect2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.webapp.mentorconnect2.models.Appointment; 
import java.util.List; 
import java.util.Map;

public interface AppointmentService extends CrudRepository<Appointment, Long>{
    //Add query methods
}
