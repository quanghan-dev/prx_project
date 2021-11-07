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
import services.CompanyService;
import services.UtilService;

@WebServlet("/create-project")
public class CreateProjectController extends HttpServlet {

    private static final String HOME = "/project/home.jsp";
    private static final String CREATE_PROJECT = "/project/create_project.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        try {
            UtilService utilService = new UtilService();
            String id = utilService.CreateId();

            String name = request.getParameter("name");
            String language = request.getParameter("language");

            Project project = new Project(id, name, language);
            
            CompanyService companyService = new CompanyService();
            
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);           
            company.getProjects().add(project);
            request.setAttribute("COMPANY", company);
            
            companyService.MarshallerCompany(company, realPath);
            
            url = HOME;
        } catch (Exception e) {
            log("ERROR at CreateProjectController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(CREATE_PROJECT);
        rd.forward(request, response);
    }

}
