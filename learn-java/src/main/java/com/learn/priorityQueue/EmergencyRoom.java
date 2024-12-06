package com.learn.priorityQueue;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1. PriorityQueue – Example: Emergency Room Triage System
 * The PriorityQueue is not a typical FIFO queue; instead, it serves elements based on their priority.
 * This is useful in scenarios where some tasks need to be processed before others, regardless of arrival order.

 * Scenario: Emergency Room Triage System
 * In an emergency room, patients are triaged based on the severity of their condition.
 * Patients with more critical conditions are treated before others, even if they arrived later.
 */
public class EmergencyRoom {
    private final Queue<Patient> patientQueue;

    public EmergencyRoom() {
        this.patientQueue = new PriorityQueue<>();
    }

    public void admitPatient(Patient newPatient) {
        patientQueue.add(newPatient);
        System.out.println(newPatient.getName()+" Admitted");
    }

    public Optional<Patient> treatPatient() {
        return Optional.ofNullable(patientQueue.poll())
                .map(patient -> {
                    System.out.println("Treated to Patient"+ patient);
                    return patient;
                });
    }

    public static void main(String[] args) {
        EmergencyRoom emergencyRoom = new EmergencyRoom();

        emergencyRoom.admitPatient(new Patient("Saj", 2));
        emergencyRoom.admitPatient(new Patient("Isu", 7));
        emergencyRoom.admitPatient(new Patient("Kas", 5));
        emergencyRoom.admitPatient(new Patient("Nur", 8));

        Optional<Patient> patient1 = emergencyRoom.treatPatient();
        patient1.ifPresent(patient -> System.out.println(patient.getName()+" Exited"));

        Optional<Patient> patient2 = emergencyRoom.treatPatient();
        patient2.ifPresent(patient -> System.out.println(patient.getName()+" Exited"));

        Optional<Patient> patient3 = emergencyRoom.treatPatient();
        patient3.ifPresent(patient -> System.out.println(patient.getName()+" Exited"));

        Optional<Patient> patient4 = emergencyRoom.treatPatient();
        patient4.ifPresent(patient -> System.out.println(patient.getName()+" Exited"));

        Optional<Patient> patient5 = emergencyRoom.treatPatient();
        patient5.ifPresent(patient -> System.out.println(patient.getName()+" Exited"));
    }
}
