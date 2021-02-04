package ru.job4j.oop;

public class Surgeon extends Doctor{

    private String specialisation;

    public String getSpecialisation() {
        return specialisation;
    }

    public boolean canOperation (Patient patient) {
        return specialisation.equals(patient.getDiagnose());
    }
}
