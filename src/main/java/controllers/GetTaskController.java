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
import models.Sprint;
import services.CompanyService;

/**
 *
 * @author User
 */
@WebServlet("/task")
public class GetTaskController extends HttpServlet {

    private static final String TASK = "/task.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String sprint_id = request.getParameter("sprint_id");
        try {
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";

            CompanyService companyService = new CompanyService();
            Company company = companyService.UnmarshallerCompany(realPath);
            Sprint sprint = null;
            for(Project p : company.getProjects()) {
                if(p.getId().equals(project_id)){
                    for(Sprint s: p.getSprints()) {
                        if(s.getId().equals(sprint_id))
                            sprint = s;
                    }
                }
            }                    
                request.setAttribute("SPRINT", sprint);
                request.setAttribute("PROJECT_ID", project_id);
                request.setAttribute("SPRINT_ID", sprint_id);
                url = TASK;
        } catch (Exception e) {
            log("ERROR at GetTaskController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

}