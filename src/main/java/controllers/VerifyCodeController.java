package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verify")
public class VerifyCodeController extends HttpServlet {

    private static final String MANAGER = "/manager/manager.jsp";
    private static final String VERIFY_MANAGER = "/manager/verify.jsp";
    private static final String HOME = "/Project/project";
    private static final String ERROR = "/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(VERIFY_MANAGER);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            int code = Integer.parseInt(request.getParameter("code"));
            System.out.println(code);
            System.out.println(session.getAttribute("CODE"));
            if ((int) session.getAttribute("CODE") == code) {
                session.removeAttribute("CODE");
                ProjectController controller = new ProjectController();
                response.sendRedirect(HOME);
            } else {
                request.setAttribute("ERROR", "error");
                url = VERIFY_MANAGER;
                request.getRequestDispatcher(url).forward(request, response);

            }
        } catch (Exception e) {
            log("ERROR at VerifyCodeController: " + e.getMessage());

        }
    }
}
