package ru.job4j.oop;

public class Builder extends Engineer{

    private boolean haveProject;
    private boolean haveMaterial;

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
