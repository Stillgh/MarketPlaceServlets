package servlet;

import dao.DataBaseInitialization;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Item;
import service.BidValidation;
import service.GetFromItemsService;
import service.GetFromUsersService;
import service.UpdateItemsService;

public class ItemsServlet extends HttpServlet {

  public ArrayList<Item> pushingItemsToFront() {
    GetFromItemsService getFromItemsService = new GetFromItemsService();
    return getFromItemsService.getAllItems();
  }

  public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
      throws IOException, ServletException {

    httpServletRequest.setAttribute("items", pushingItemsToFront());
    httpServletRequest.getServletContext().getRequestDispatcher("/items.jsp")
        .forward(httpServletRequest, httpServletResponse);

  }


  protected void doPost(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) throws IOException {



    HttpSession session = httpServletRequest.getSession();
    String userName = (String) session.getAttribute("userName");
    session.setAttribute("itemID", httpServletRequest.getParameter("it"));

    String bidStr = httpServletRequest.getParameter("bd");
    int bid = Integer.parseInt(bidStr);
    int itemID = Integer.parseInt((String) session.getAttribute("itemID"));

    GetFromUsersService getFromUsersService = new GetFromUsersService();
    UpdateItemsService updateItemsService = new UpdateItemsService();

    if (!BidValidation.validateBid(itemID, bid)) {
      DataBaseInitialization.dropDataBase();
      httpServletResponse.sendRedirect("invalidBid.jsp");
    } else {
      httpServletRequest.setAttribute("items", pushingItemsToFront());
      int bidderID = getFromUsersService.findUserID(userName);
      updateItemsService.setBidAndBidderID(bid, bidderID, itemID);
      httpServletResponse.sendRedirect("itemsservlet");
    }

  }
}
