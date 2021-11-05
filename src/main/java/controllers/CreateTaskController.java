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
import models.Project;
import models.Sprint;
import models.Task;
import services.CompanyService;
import services.UtilService;

@WebServlet("/create-task")
public class CreateTaskController extends HttpServlet {

    private static final String TASK = "/task.jsp";
    private static final String CREATE_TASK = "/create_task.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String sprint_id = request.getParameter("sprint_id");
        try {
            UtilService utilService = new UtilService();
            String id = utilService.CreateId();

            String name = request.getParameter("name");
            String duration = request.getParameter("duration");
            String status = request.getParameter("status");

            Task task = new Task(id, name, duration, status);
            List<Task> listTask = new ArrayList<>();
            CompanyService companyService = new CompanyService();

            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);

            Sprint sprint = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(project_id)) {
                    for (Sprint s : p.getSprints()) {
                        if (s.getId().equals(sprint_id)) {
                            sprint = s;
                            s.getTasks().add(task);
                        }
                    }
                }
            }

            request.setAttribute("SPRINT", sprint);
            request.setAttribute("PROJECT_ID", project_id);
            request.setAttribute("SPRINT_ID", sprint_id);

            companyService.MarshallerCompany(company, realPath);

            url = TASK;

        } catch (Exception e) {
            log("ERROR at CreateTaskController: " + e.getMessage());

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
            url = CREATE_TASK;
        } catch (Exception e) {
            log("ERROR at CreateTaskController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

}
