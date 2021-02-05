package ru.job4j.oop;

public class Builder extends Engineer{

    private boolean haveProject;
    private boolean haveMaterial;

    public Builder(String name, String surname, String education, String birthday, String qualification, boolean haveProject, boolean haveMaterial) {
        super(name, surname, education, birthday, qualification);
        this.haveProject = haveProject;
        this.haveMaterial = haveMaterial;
    }

    public boolean isHaveProject() {
        return haveProject;
    }

    public boolean isHaveMaterial() {
        return haveMaterial;
    }

    public String canWork() {
        if (haveMaterial && haveProject) {
            return "Let's work";
        } else {
            return "Relax";
        }
    }
}
