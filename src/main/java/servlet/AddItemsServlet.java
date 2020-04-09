package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.GetFromUsersService;
import service.UpdateItemsService;


public class AddItemsServlet extends HttpServlet {

  public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
      throws IOException, ServletException {

    ServletContext sc = this.getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/addItems.jsp");
    rd.forward(httpServletRequest, httpServletResponse);
  }

  @Override
  protected void doPost(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) throws IOException {

    String title = httpServletRequest.getParameter("tl");
    String description = httpServletRequest.getParameter("des");
    float startPrice = Float.parseFloat(httpServletRequest.getParameter("sp"));
    String endDateStr = httpServletRequest.getParameter("ed");
    String startDateStr = httpServletRequest.getParameter("sd");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date endDate = null;
    Date startDate = null;

    try {
      endDate = simpleDateFormat.parse(endDateStr);
      startDate = simpleDateFormat.parse(startDateStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
    java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());

    GetFromUsersService getFromUsersService = new GetFromUsersService();
    HttpSession session = httpServletRequest.getSession();
    String userName = (String) session.getAttribute("userName");
    int ID = getFromUsersService.findUserID(userName);

    UpdateItemsService updateItemsService = new UpdateItemsService();
    updateItemsService.addItem(title, description, ID, startPrice, 0, 0, sqlEndDate, sqlStartDate);

    httpServletResponse.sendRedirect("myitemsservlet");
  }
}
