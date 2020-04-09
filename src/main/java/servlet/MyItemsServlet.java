package servlet;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Item;
import service.GetFromItemsService;
import service.GetFromUsersService;
import service.UpdateItemsService;


public class MyItemsServlet extends HttpServlet {


  public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
      throws IOException, ServletException {



    HttpSession session = httpServletRequest.getSession();
    String userName = (String) session.getAttribute("userName");

    GetFromUsersService getFromUsersService = new GetFromUsersService();
    int userID = getFromUsersService.findUserID(userName);

    GetFromItemsService getFromItemsService = new GetFromItemsService();
    ArrayList<Item> items = getFromItemsService.getMyItems(userID);
    httpServletRequest.setAttribute("items", items);

    ServletContext sc = this.getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher("/myItems.jsp");
    rd.forward(httpServletRequest, httpServletResponse);

  }


  protected void doPost(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) throws IOException {

    UpdateItemsService updateItemsService = new UpdateItemsService();
    String itemIDStr = httpServletRequest.getParameter("it");
    int itemID = Integer.parseInt(itemIDStr);

    updateItemsService.deleteItem(itemID);
    httpServletResponse.sendRedirect("myitemsservlet");


  }
}
