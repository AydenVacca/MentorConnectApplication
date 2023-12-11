// package com.webapp.mentorconnect2.models;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.Getter;
// import lombok.Setter;

// @Entity
// @Table(name = "Appointment")
// public class Appointment {
    
//     @Id
//     @GeneratedValue(strategy= GenerationType.AUTO)
//     @Getter
//     @Setter
//     private long appointmentID;

//     @Getter
//     @Setter
//     private long menteeID;

//     @Getter
//     @Setter
//     private long mentorID;

//     @Getter
//     @Setter
//     private String date;

//     @Getter
//     @Setter
//     private boolean confirmed;

//     //Default Constructor
//     public Appointment(){

//     }

//     public Appointment(long appointmentID, long menteeID, long mentorID, String date, boolean confirmed){
//         this.appointmentID = appointmentID;
//         this.menteeID = menteeID;
//         this.mentorID = mentorID;
//         this.date = date;
//         this.confirmed = confirmed;
//     }
// }