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

@WebServlet("/delete-project")
public class DeleteProjectController extends HttpServlet {

    private static final String HOME = "/project/project.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String id = request.getParameter("project_id");

        try {
            CompanyService companyService = new CompanyService();
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);

            for (int i = 0; i < company.getProjects().size(); i++) {
                if(company.getProjects().get(i).getId().equals(id)) {
                    company.getProjects().remove(i);
                }
            }
            companyService.MarshallerCompany(company, realPath);
            request.setAttribute("COMPANY", company);

            url = HOME;
        } catch (Exception e) {
            log("ERROR at DeleteProjectController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    
}
