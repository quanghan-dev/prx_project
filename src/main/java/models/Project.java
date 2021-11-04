package models;


import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project implements Serializable{
    
    @XmlAttribute
    private String id;
    
    private String name;
    
    private String language;

    @XmlElement(name="sprint")
    private List<Sprint> sprints;

    public Project() {
    }

    public Project(String id, String name, String language, List<Sprint> sprints) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.sprints = sprints;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + ", language=" + language + ", sprints=" + sprints + '}';
    }
    
    
    
}
