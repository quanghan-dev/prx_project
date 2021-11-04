package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Company;
import services.CompanyService;

@WebServlet("/home")
public class CompanyController extends HttpServlet {

    private static final String HOME = "/home.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = ERROR;
        try {
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            
            CompanyService companyService = new CompanyService();
            Company company = companyService.Unmarshaller(realPath);
            
            if (company != null) {
                request.setAttribute("PROJECTS", company.getProjects());
                url = HOME;
            }
        } catch (Exception e) {
            log("ERROR at ProjectController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

}
