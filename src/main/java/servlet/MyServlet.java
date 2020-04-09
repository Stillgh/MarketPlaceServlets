package servlet;


import dao.DataBaseInitialization;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserValidationService;

public class MyServlet extends HttpServlet {

  final String GUEST = "Guest";


  public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
      throws IOException, ServletException {

    ServletContext sc = this.getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/login.jsp");
    rd.forward(httpServletRequest, httpServletResponse);
  }


  protected void doPost(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) throws IOException {

    String login = httpServletRequest.getParameter("un");
    String password = httpServletRequest.getParameter("pw");

    HttpSession session = httpServletRequest.getSession(true);

    if (Objects.isNull((httpServletRequest.getParameter("gt")))) {
      session.setAttribute("userName", httpServletRequest.getParameter("un"));
      session.setAttribute("password", httpServletRequest.getParameter("pw"));
      UserValidationService userValidationService = new UserValidationService();

      if (userValidationService.loginValidity(login, password).get()) {

        DataBaseInitialization dataBaseInitialization = new DataBaseInitialization();

        httpServletResponse.sendRedirect("/itemsservlet");
      } else {
        httpServletResponse.sendRedirect("invalidLogin.jsp");
      }

    } else if (httpServletRequest.getParameter("gt").equals(GUEST)) {
      session.setAttribute("userName", "Guest");
      session.setAttribute("password", "0");
      httpServletResponse.sendRedirect("/itemsservlet");
    }

  }
}
