package servlet;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterService {


  public static void filterUsers(ServletRequest request, ServletResponse response,
      FilterChain filterChain)
      throws ServletException, IOException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    HttpSession session = httpRequest.getSession();
    String userName = (String) session.getAttribute("userName");


    if (Objects.isNull(userName) || userName.equals("Guest")) {
      httpResponse.sendRedirect("/myservlet");
    } else  {
      filterChain.doFilter(request, response);
    }

//    if (!Objects.nonNull(userName) || !userName.equals("Guest")) {
//      filterChain.doFilter(request, response);
//    } else {
//      httpResponse.sendRedirect("/myservlet");
//    }
  }
}
