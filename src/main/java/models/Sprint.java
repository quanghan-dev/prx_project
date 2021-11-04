package models;


import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "sprint")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sprint implements Serializable{
    
    @XmlAttribute
    private String id;
    
    private String name;
    
    private String duration;
    
    @XmlElement(name="task")
    private List<Task> tasks;

    public Sprint() {
    }

    public Sprint(String id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Sprint{" + "id=" + id + ", name=" + name + ", duration=" + duration + ", tasks=" + tasks + '}';
    }
    
    
}
