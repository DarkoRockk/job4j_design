package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() throws JAXBException, IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void forHR() throws JAXBException, IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Boris", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));

    }

    @Test
    public void forProg() throws JAXBException, IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportProg(store);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE HTML>")
                .append("<html><head><meta charset=\"utf-8\"><title>Report</title></head><body><table>")
                .append("<tr>")
                .append("<th>Name</th>")
                .append("<th>Hired</th>")
                .append("<th>Fired</th>")
                .append("<th>Salary</th>")
                .append("</tr>")
                .append("<tr><td>").append(worker.getName()).append("</tr><td>")
                .append("<tr><td>").append(worker.getHired()).append("</tr><td>")
                .append("<tr><td>").append(worker.getFired()).append("</tr><td>")
                .append("<tr><td>").append(worker.getSalary()).append("</tr><td>")
                .append("</table></body></html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void forFinance() throws JAXBException, IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportFinance(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary USD;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() / 72).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));

    }

//    @Test
//    public void ifJSON() throws JAXBException, IOException {
//        MemStore store = new MemStore();
//        Calendar now = Calendar.getInstance();
//        Employee worker = new Employee("Ivan", now, now, 100);
//        store.add(worker);
//        Report engine = new ReportJSON(store);
//        System.out.println(engine.generate(em -> true));
//        StringBuilder expect = new StringBuilder()
//                .append("{\"name\":\"").append(worker.getName()).append("\",");
//        System.out.println(expect.toString());
//        assertThat(engine.generate(em -> true), is(expect));
//    }

    @Test
    public void ifXML() throws JAXBException, IOException {
        MemStore store = new MemStore();
        SimpleDateFormat cFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report report = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employee name=\"").append(worker.getName()).append("\" ")
                .append("hired=\"").append(cFormatter.format(worker.getHired().getTime())).append("\" ")
                .append("fired=\"").append(cFormatter.format(worker.getFired().getTime())).append("\" ")
                .append("salary=\"").append(worker.getSalary()).append("\"/>\n");
        assertThat(report.generate(em -> true), is(expect.toString()));
    }
}