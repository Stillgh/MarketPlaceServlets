package servlet;


import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

  public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
      throws IOException {

    httpServletResponse.setContentType("text/html");
    HttpSession session = httpServletRequest.getSession();
    session.invalidate();
    httpServletResponse.sendRedirect("myservlet");

  }


  protected void doPost(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
  }
}
