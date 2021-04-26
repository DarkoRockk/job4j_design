package ru.job4j.serialization;

import java.io.Serializable;
import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "vaccination")
public class Vaccination implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlAttribute
    private String drug;
    @XmlAttribute
    private double version;

    public Vaccination() {
    }

    public Vaccination(String drug, double version) {
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
