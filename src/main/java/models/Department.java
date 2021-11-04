package models;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "department")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department implements Serializable{
    
    @XmlAttribute
    private String id;
    
    private String name;

    public Department() {
    }

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + '}';
    }

    
    
    
}
