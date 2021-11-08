package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.ManagerService;
import services.SendingEmail;

@WebServlet("")
public class ValidateManagerController extends HttpServlet {

    private static final String MANAGER = "/manager/manager.jsp";
    private static final String VERIFY_MANAGER = "/manager/verify.jsp";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("PROJECT_ID", request.getParameter("project_id"));
        session.setAttribute("SPRINT_ID", request.getParameter("sprint_id"));
        RequestDispatcher rd = getServletContext().getRequestDispatcher(MANAGER);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        try {
            String email = request.getParameter("email");

            ManagerService managerService = new ManagerService();
            if (managerService.GetManagerByEmail(email) != null) {
                SendingEmail sendEmail = new SendingEmail();
                int code = sendEmail.sendEmail(email);
                if (code != 0) {
                    HttpSession session = request.getSession();
                    session.setAttribute("CODE", code);
                    session.setAttribute("MANAGER", managerService.GetManagerByEmail(email));
                    url = VERIFY_MANAGER;
                }
            }
        } catch (Exception e) {
            log("ERROR at ManagerController: " + e.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
