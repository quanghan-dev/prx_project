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

@WebServlet("/update-task")
public class UpdateTaskController extends HttpServlet {
    
    private static final String TASK = "/task.jsp";
    private static final String UPDATE_TASK = "/update_task.jsp";
    private static final String ERROR = "/error.jsp";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String task_id = request.getParameter("task_id");
        String sprint_id = request.getParameter("sprint_id");
        String name = request.getParameter("name");
        String duration = request.getParameter("duration");
        String status = request.getParameter("status");
        
        try {
            CompanyService companyService = new CompanyService();
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);
            Task task = new Task(task_id, name, duration, status);
            Sprint sprint = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(project_id)) {
                    for (Sprint s : p.getSprints()) {
                        if (s.getId().equals(sprint_id)) {
                            sprint = s;
                            for (int i = 0; i < s.getTasks().size(); i++) {
                                if (s.getTasks().get(i).getId().equals(task_id)) {
                                    s.getTasks().set(i, task);
                                }
                            }
                        }
                    }
                }
            }
            
            request.setAttribute("SPRINT", sprint);
            request.setAttribute("PROJECT_ID", project_id);
            request.setAttribute("SPRINT_ID", sprint_id);
            
            companyService.MarshallerCompany(company, realPath);
            
            url = TASK;
        } catch (Exception e) {
            log("ERROR at UpdateTaskController: " + e.getMessage());
            
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String url = ERROR;
        String project_id = request.getParameter("project_id");
        String sprint_id = request.getParameter("sprint_id");
        String task_id = request.getParameter("task_id");
        try {
            CompanyService companyService = new CompanyService();
            String realPath = getServletContext().getRealPath("/WEB-INF/") + "\\";
            Company company = companyService.UnmarshallerCompany(realPath);
            Task task = null;
            Sprint sprint = null;
            for (Project p : company.getProjects()) {
                if (p.getId().equals(project_id)) {
                    for (Sprint s : p.getSprints()) {
                        if (s.getId().equals(sprint_id)) {
                            sprint = s;
                            for (Task t : s.getTasks()) {
                                if (t.getId().equals(task_id)) {
                                    task = t;
                                }
                            }
                        }
                    }
                }
            }
            if (task != null) {
                request.setAttribute("TASK", task);
                request.setAttribute("SPRINT", sprint);
                request.setAttribute("PROJECT_ID", project_id);
                request.setAttribute("SPRINT_ID", sprint_id);
                url = UPDATE_TASK;
            }
        } catch (Exception e) {
            log("ERROR at UpdateProjectController: " + e.getMessage());
            
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
        
    }
    
}
