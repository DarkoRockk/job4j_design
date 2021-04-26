package ru.job4j.serialization;

import java.io.Serializable;

public class Vaccination implements Serializable {
    private static final long serialVersionUID = 1L;
    private String drug;
    private float version;

    public Vaccination(String drug, float version) {
        this.drug = drug;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Vaccination{"
                + "drug='" + drug + '\''
                + ", version=" + version
                + '}';
    }
}
