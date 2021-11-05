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
import models.Task;
import services.CompanyService;

/**
 *
 * @author User
 */
@WebServlet("/employee")
public class GetEmployeeController extends HttpServlet {

    private static final String EMPLOYEE = "/employee.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        
        String project_id = request.getParameter("project_id");
        String sprint_id = request.getParameter("sprint_id");
        String task_id = request.getParameter("task_id");
        
        try {
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";

            CompanyService companyService = new CompanyService();
            Company company = companyService.UnmarshallerCompany(realPath);
            Task task = null;
            for(Project p : company.getProjects()) {
                if(p.getId().equals(project_id)){
                    for(Sprint s: p.getSprints()) {
                        if(s.getId().equals(sprint_id))
                            for (Task t : s.getTasks()) {
                                task = t;
                            }
                    }
                }
            }                    
                request.setAttribute("TASK", task);
                request.setAttribute("PROJECT_ID", project_id);
                request.setAttribute("SPRINT_ID", sprint_id);
                request.setAttribute("TASK_ID", task_id);
                url = EMPLOYEE;
        } catch (Exception e) {
            log("ERROR at GetTaskController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

}