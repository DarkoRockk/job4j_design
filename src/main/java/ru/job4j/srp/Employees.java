package ru.job4j.srp;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
    public Employees() { }

    @XmlElement(name = "employee")
    private List<Employee> employees;

    public Employees(List<Employee> list) {
        this.employees = list;
    }
}
