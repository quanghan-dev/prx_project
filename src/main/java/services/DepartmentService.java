package services;

import java.util.ArrayList;
import models.Department;

public class DepartmentService {

    private ArrayList<Department> departments;

    public DepartmentService() {
        departments = new ArrayList<>();
        departments.add(new Department("D001", "Programming"));
        departments.add(new Department("D002", "Front-End"));
        departments.add(new Department("D003", "Back-End"));
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }
    
    public Department getDepartmentById(String id) {
        for(Department d : departments) {
            if(d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }
}
