package ru.job4j.serialization;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "animal")
@XmlAccessorType(XmlAccessType.FIELD)
public class Animal {
    @XmlAttribute
    private boolean sex;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private String name;
    @XmlElement
    private Vaccination vaсcine;
    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] statuses;

    public Animal() {
    }

    public Animal(boolean sex, int age, String name, Vaccination vaccine, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.vaсcine = vaccine;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "sex=" + sex
                + ", age=" + age
                + ", name='" + name + '\''
                + ", vaсcine=" + vaсcine
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) throws JAXBException, IOException {

        Animal animal = new Animal(false, 6, "Jack", new Vaccination("Nobivak", 3.5), "RJCh", "RCh");


        JAXBContext context = JAXBContext.newInstance(Animal.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {

            marshaller.marshal(animal, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Animal result = (Animal) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}
