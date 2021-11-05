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
import services.CompanyService;
import services.UtilService;

@WebServlet("/create-sprint")
public class CreateSprintController extends HttpServlet {

    private static final String SPRINT = "/sprint.jsp";
    private static final String CREATE_SPRINT = "/create_sprint.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        try {
            UtilService utilService = new UtilService();
            String id = utilService.CreateId();

            String name = request.getParameter("name");
            String duration = request.getParameter("duration");

            Sprint sprint = new Sprint(id, name, duration);
            CompanyService companyService = new CompanyService();

            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);

            Project project = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(project_id)) {
                    project = p;
                    p.getSprints().add(sprint);
                }
            }

            request.setAttribute("PROJECT", project);
            request.setAttribute("PROJECTID", project_id);

            companyService.MarshallerCompany(company, realPath);

            url = SPRINT;

        } catch (Exception e) {
            log("ERROR at CreateSprintController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(CREATE_SPRINT);
        rd.forward(request, response);
    }
}
