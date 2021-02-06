package ru.job4j.oop;

public class Surgeon extends Doctor{

    private String specialisation;

    public Surgeon(String name, String surname, String education, String birthday, String degree, String specialisation) {
        super(name, surname, education, birthday, degree);
        this.specialisation = specialisation;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public boolean canOperation (Patient patient) {
        return specialisation.equals(patient.getDiagnose());
    }
}
