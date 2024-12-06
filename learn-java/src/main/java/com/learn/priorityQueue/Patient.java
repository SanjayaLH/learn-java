package com.learn.priorityQueue;

public class Patient implements Comparable<Patient> {
    private String name;
    private int severity; // Higher number indicates more severe condition

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.getSeverity(), this.severity);  // Higher severity first
    }

    @Override
    public String toString() {
        return "Patient: " + name + ", Severity: " + severity;
    }
}