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

@WebServlet("/update-project")
public class UpdateProjectController extends HttpServlet {

    private static final String HOME = "/home.jsp";
    private static final String UPDATE_PROJECT = "/update_project.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String id = request.getParameter("project_id");
        String name = request.getParameter("name");
        String language = request.getParameter("language");

        try {
            CompanyService companyService = new CompanyService();
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);
            Project project = new Project(id, name, language);

            for (int i = 0; i < company.getProjects().size(); i++) {
                if(company.getProjects().get(i).getId().equals(id)) {
                    company.getProjects().set(i, project);
                }
            }
            companyService.MarshallerCompany(company, realPath);
            request.setAttribute("COMPANY", company);

            url = HOME;
        } catch (Exception e) {
            log("ERROR at UpdateProjectController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = ERROR;
        String id = request.getParameter("project_id");

        try {
            CompanyService companyService = new CompanyService();
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);
            Project project = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(id)) {
                    project = p;
                }
            }
            if (project != null) {
                request.setAttribute("PROJECT", project);
                url = UPDATE_PROJECT;
            }
        } catch (Exception e) {
            log("ERROR at UpdateProjectController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

}
