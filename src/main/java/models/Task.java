package models;


import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class Task implements Serializable{
    
    @XmlAttribute
    private String id;
    
    private String name;
    
    private String duration;
    
    private String status;
    
    @XmlElement(name="manager")
    private Manager manager;
    
    @XmlElementWrapper(name="employeeAssigned")
    @XmlElement(name="employee")
    private List<Employee> employees;

    public Task() {
    }

    public Task(String id, String name, String duration, String status, Manager manager) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.status = status;
        this.manager = manager;
    }

    public Task(String id, String name, String duration, String status) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.status = status;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name=" + name + ", duration=" + duration + ", status=" + status + ", manager=" + manager + ", employees=" + employees + '}';
    }
    
    
}
