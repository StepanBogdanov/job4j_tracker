package ru.job4j.oop;

public class Engineer extends Profession{

    private String qualification;

    public Engineer(String name, String surname, String education, String birthday, String qualification) {
        super(name, surname, education, birthday);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }
}
