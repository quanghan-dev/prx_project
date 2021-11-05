package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Company;
import models.Employee;
import models.Project;
import models.Sprint;
import models.Task;
import services.CompanyService;
import services.UtilService;

@WebServlet("/create-employee")
public class CreateEmployeeController extends HttpServlet {

    private static final String EMPLOYEE = "/employee.jsp";
    private static final String CREATE_EMPLOYEE = "/create_employee.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String sprint_id = request.getParameter("sprint_id");
        String task_id = request.getParameter("task_id");
        try {
            UtilService utilService = new UtilService();
            String id = utilService.CreateId();

            String name = request.getParameter("name");

            Employee employee = new Employee(id, name);

            CompanyService companyService = new CompanyService();

            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);

            Task task = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(project_id)) {
                    for (Sprint s : p.getSprints()) {
                        if (s.getId().equals(sprint_id)) {
                            for (Task t : s.getTasks()) {
                                if (t.getId().equals(task_id)) {
                                    task = t;
                                    if (t.getEmployees() == null) {
                                        List<Employee> listEmp = new ArrayList<>();
                                        listEmp.add(employee);
                                        t.setEmployees(listEmp);
                                    } else {
                                        t.getEmployees().add(employee);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            request.setAttribute("TASK", task);
            request.setAttribute("PROJECT_ID", project_id);
            request.setAttribute("SPRINT_ID", sprint_id);

            companyService.MarshallerCompany(company, realPath);

            url = EMPLOYEE;

        } catch (Exception e) {
            log("ERROR at CreateEmployeeController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String sprint_id = request.getParameter("sprint_id");
        try {
            request.setAttribute("PROJECT_ID", project_id);
            request.setAttribute("SPRINT_ID", sprint_id);
            url = CREATE_EMPLOYEE;
        } catch (Exception e) {
            log("ERROR at CreateEmployeeController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

}
