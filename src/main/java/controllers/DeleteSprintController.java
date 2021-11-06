package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Company;
import models.Project;
import services.CompanyService;

@WebServlet("/delete-sprint")
public class DeleteSprintController extends HttpServlet {

    private static final String SPRINT = "/sprint.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String sprint_id = request.getParameter("sprint_id");

        try {
            CompanyService companyService = new CompanyService();
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);

            Project project = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(project_id)) {
                    for (int i = 0; i < p.getSprints().size(); i++) {
                        if (sprint_id.equals(p.getSprints().get(i).getId())) {
                            p.getSprints().remove(i);
                            project = p;
                        }
                    }
                }
            }
            companyService.MarshallerCompany(company, realPath);
            request.setAttribute("PROJECT", project);
            request.setAttribute("PROJECT_ID", project_id);

            url = SPRINT;
        } catch (Exception e) {
            log("ERROR at DeleteSprintController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
