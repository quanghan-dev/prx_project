package models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company implements Serializable {
    
    @XmlElement(name="project")
    private List<Project> projects;

    public Company() {
        projects = new ArrayList<>();
    }

    public Company(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Company{" + "projects=" + projects + '}';
    }
    
    
}
