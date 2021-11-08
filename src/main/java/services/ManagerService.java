package services;

import java.util.ArrayList;
import models.Department;
import models.Manager;

public class ManagerService {

    private ArrayList<Manager> managers;

    public ManagerService() {
        managers = new ArrayList<>();
        DepartmentService departmentService = new DepartmentService();
        managers.add(new Manager("f01900b9-ae39-42ca-b904-fb2b9ca187f1", "Han Quang", "hannqse140027@fpt.edu.vn", departmentService.getDepartmentById("D003")));
        managers.add(new Manager("f02900b9-ae39-42ca-b904-fb2b9ca187f2", "Tran Thanh Long", "longttse140019@fpt.edu.vn", departmentService.getDepartmentById("D002")));
        managers.add(new Manager("f03900b9-ae39-42ca-b904-fb2b9ca187f3", "Pham Le Phuc Anh", "anhplpse140022@fpt.edu.vn", departmentService.getDepartmentById("D001")));
        managers.add(new Manager("f04900b9-ae39-42ca-b904-fb2b9ca187f4", "Khoi Le", "khoildase140074@fpt.edu.vn", departmentService.getDepartmentById("D003")));
    }

    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public Manager GetManagerByEmail(String email) {
        for(Manager m : managers) {
            if(m.getEmail().equals(email))
                return m;
        }
        return null;
    }
    
}
