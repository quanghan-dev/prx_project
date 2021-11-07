package controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Company;
import models.Department;
import models.Employee;
import models.Project;
import models.Sprint;
import models.Task;
import services.CompanyService;
import services.DepartmentService;

@WebServlet("/update-employee")
public class UpdateEmployeeController extends HttpServlet {

    private static final String EMPLOYEE = "/employee/employee.jsp";
    private static final String UPDATE_EMPLOYEE = "/employee/update_employee.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String task_id = request.getParameter("task_id");
        String employee_id = request.getParameter("employee_id");
        String sprint_id = request.getParameter("sprint_id");
        String name = request.getParameter("name");
        String department_id = request.getParameter("department");

        try {
            CompanyService companyService = new CompanyService();
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);
            
            DepartmentService departmentService = new DepartmentService();
            Department department = departmentService.getDepartmentById(department_id);
            
            Task task = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(project_id)) {
                    for (Sprint s : p.getSprints()) {
                        if (s.getId().equals(sprint_id)) {
                            for (Task t : s.getTasks()) {
                                if (t.getId().equals(task_id)) {
                                    for (int i = 0; i < t.getEmployees().size(); i++) {
                                        if (t.getEmployees().get(i).getId().equals(employee_id)) {
                                            t.getEmployees().get(i).setName(name);
                                            t.getEmployees().get(i).setDepartment(department);
                                            task = t;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            request.setAttribute("TASK", task);
            request.setAttribute("SPRINT_ID", sprint_id);
            request.setAttribute("PROJECT_ID", project_id);

            companyService.MarshallerCompany(company, realPath);

            url = EMPLOYEE;
        } catch (Exception e) {
            log("ERROR at UpdateEmployeeController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String sprint_id = request.getParameter("sprint_id");
        String task_id = request.getParameter("task_id");
        String employee_id = request.getParameter("employee_id");
        try {
            CompanyService companyService = new CompanyService();
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);
            Task task = null;
            Employee employee = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(project_id)) {
                    for (Sprint s : p.getSprints()) {
                        if (s.getId().equals(sprint_id)) {
                            for (Task t : s.getTasks()) {
                                if (t.getId().equals(task_id)) {
                                    task = t;
                                    for (Employee e : t.getEmployees()) {
                                        if (e.getId().equals(employee_id)) {
                                            employee = e;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (task != null) {

                DepartmentService departmentService = new DepartmentService();
                ArrayList<Department> departments = departmentService.getDepartments();

                request.setAttribute("DEPARTMENTS", departments);
                request.setAttribute("TASK", task);
                request.setAttribute("EMPLOYEE", employee);
                request.setAttribute("PROJECT_ID", project_id);
                request.setAttribute("SPRINT_ID", sprint_id);
                url = UPDATE_EMPLOYEE;
            }
        } catch (Exception e) {
            log("ERROR at UpdateProjectController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

}
