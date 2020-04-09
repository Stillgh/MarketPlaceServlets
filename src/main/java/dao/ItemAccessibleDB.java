package dao;


import java.util.ArrayList;
import java.util.Date;
import model.Item;

public interface ItemAccessibleDB {

  void setBidAndBidderID(int bid, int bidderID, int itemID);
  ArrayList<Item> getAllItems();
  ArrayList<Item> getMyItems(int userID );
  float getStartPrice (int itemID);
  float getCurrentBid(int itemID);
  void addItem(String title, String description, int sellerID, float startPrice, float bestOffer, int bidderId, Date endDate, Date startDate );
  void deleteItem(int itemID);
  void updateStopDate(int itemID, Date newStopDate);



}
