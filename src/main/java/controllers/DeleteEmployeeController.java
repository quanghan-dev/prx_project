package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Company;
import models.Project;
import models.Sprint;
import models.Task;
import services.CompanyService;

@WebServlet("/delete-employee")
public class DeleteEmployeeController extends HttpServlet {

    private static final String EMPLOYEE = "/employee.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String task_id = request.getParameter("task_id");
        String sprint_id = request.getParameter("sprint_id");
        String employee_id = request.getParameter("employee_id");

        try {
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
                                    for (int i = 0; i < t.getEmployees().size(); i++) {
                                        if (t.getEmployees().get(i).getId().equals(employee_id)) {
                                            t.getEmployees().remove(i);
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
            companyService.MarshallerCompany(company, realPath);
            
            request.setAttribute("SPRINT_ID", sprint_id);
            request.setAttribute("TASK", task);
            request.setAttribute("PROJECT_ID", project_id);
            request.setAttribute("TASK_ID", task_id);
            url = EMPLOYEE;
        } catch (Exception e) {
            log("ERROR at DeleteTaskController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

}
