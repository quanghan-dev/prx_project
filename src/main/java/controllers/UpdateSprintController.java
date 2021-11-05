package controllers;

import java.io.IOException;
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

@WebServlet("/update-sprint")
public class UpdateSprintController extends HttpServlet {

    private static final String SPRINT = "/sprint.jsp";
    private static final String UPDATE_SPRINT = "/update_sprint.jsp";
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
            Sprint sprint = new Sprint(sprint_id, name, duration);
            System.out.println(sprint);
            Project project = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(project_id)) {
                    project = p;
                    for (int i = 0; i < p.getSprints().size(); i++) {
                        if (sprint_id.equals(p.getSprints().get(i).getId())) {
                            p.getSprints().set(i, sprint);
                        }
                    }
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
        RequestDispatcher rd = getServletContext().getRequestDispatcher(UPDATE_SPRINT);
        rd.forward(request, response);
    }
}
