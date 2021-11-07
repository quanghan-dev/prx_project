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

@WebServlet("/update-sprint")
public class UpdateSprintController extends HttpServlet {

    private static final String SPRINT = "/sprint/sprint.jsp";
    private static final String UPDATE_SPRINT = "/sprint/update_sprint.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String sprint_id = request.getParameter("sprint_id");
        String name = request.getParameter("name");
        String duration = request.getParameter("duration");

        try {
            CompanyService companyService = new CompanyService();
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);
            Project project = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(project_id)) {
                    for (int i = 0; i < p.getSprints().size(); i++) {
                        if (sprint_id.equals(p.getSprints().get(i).getId())) {
                            p.getSprints().get(i).setName(name);
                            p.getSprints().get(i).setDuration(duration);
                        }
                    }
                    project = p;

                }
            }
            request.setAttribute("PROJECT", project);
            request.setAttribute("PROJECT_ID", project_id);

            companyService.MarshallerCompany(company, realPath);

            url = SPRINT;
        } catch (Exception e) {
            log("ERROR at UpdateSprintController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String id = request.getParameter("project_id");
        String sprint_id = request.getParameter("sprint_id");

        try {
            CompanyService companyService = new CompanyService();
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);
            Sprint sprint = null;
            Project project = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(id)) {
                    project = p;
                    for (Sprint s : p.getSprints()) {
                        if (s.getId().equals(sprint_id))
                            sprint = s;
                    }
                }
            }
            if (sprint != null) {
                request.setAttribute("SPRINT", sprint);
                request.setAttribute("PROJECT", project);
                url = UPDATE_SPRINT;
            }
        } catch (Exception e) {
            log("ERROR at UpdateProjectController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
