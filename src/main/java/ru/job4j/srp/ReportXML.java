package ru.job4j.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXML implements Report, Serializable {
    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException, IOException {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (StringWriter writer = new StringWriter()) {

                marshaller.marshal(employee, writer);
                text.append(writer.getBuffer().toString());
            }
        }
        return text.toString();
    }
}
