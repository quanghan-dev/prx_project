/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author User
 */
@WebServlet("/sprint")
public class GetSprintController extends HttpServlet {

    private static final String SPRINT = "/sprint.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        try {
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";

            CompanyService companyService = new CompanyService();
            Company company = companyService.UnmarshallerCompany(realPath);
            Project project = null;
            for(Project p : company.getProjects()) {
                if(p.getId().equals(project_id))
                    project = p;
            }                    
                request.setAttribute("PROJECT", project);
                url = SPRINT;
        } catch (Exception e) {
            log("ERROR at CompanyController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

}
