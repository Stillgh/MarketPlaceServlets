package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UpdateUsersService;
import service.UserValidationService;


public class RegisterServlet extends HttpServlet {


  public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
      throws IOException, ServletException {

    ServletContext sc = this.getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/register.jsp");
    rd.forward(httpServletRequest, httpServletResponse);
  }


  protected void doPost(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) throws IOException {

    String login = httpServletRequest.getParameter("un");
    String password = httpServletRequest.getParameter("pw");
    String address = httpServletRequest.getParameter("ad");
    String email = httpServletRequest.getParameter("em");
    String name = httpServletRequest.getParameter("fn");

    UserValidationService userValidationService = new UserValidationService();
    if (userValidationService.isLoginExists(login)) {
      httpServletResponse.sendRedirect("invalidRegistration.jsp");
    } else {

      UpdateUsersService updateUsersService = new UpdateUsersService();
      updateUsersService.addUser(name, address, email, login, password);

      HttpSession session = httpServletRequest.getSession(true);
      session.setAttribute("userName", httpServletRequest.getParameter("un"));
      session.setAttribute("password", httpServletRequest.getParameter("pw"));

      httpServletResponse.sendRedirect("/itemsservlet");

    }
  }
}
