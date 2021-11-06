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
import services.CompanyService;

@WebServlet("/delete-task")
public class DeleteTaskController extends HttpServlet {

    private static final String TASK = "/task.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String task_id = request.getParameter("task_id");
        String sprint_id = request.getParameter("sprint_id");

        try {
            CompanyService companyService = new CompanyService();
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);

            Sprint sprint = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(project_id)) {
                    for (Sprint s : p.getSprints()) {
                        if (s.getId().equals(sprint_id)) {
                            for (int i = 0; i < s.getTasks().size(); i++) {
                                if (s.getTasks().get(i).getId().equals(task_id)) {
                                    s.getTasks().remove(i);
                                    sprint = s;
                                }
                            }
                        }
                    }
                }
            }
            companyService.MarshallerCompany(company, realPath);

            request.setAttribute("SPRINT_ID", sprint_id);
            request.setAttribute("SPRINT", sprint);
            request.setAttribute("PROJECT_ID", project_id);

            url = TASK;
        } catch (Exception e) {
            log("ERROR at DeleteTaskController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
