package service;


import java.util.Date;

public interface ItemsUpdater {
  void setBidAndBidderID(int bid, int bidderID, int itemID);
  void addItem(String title, String description, int sellerID, float startPrice, float bestOffer, int bidderId, Date endDate, Date startDate );
  void deleteItem(int itemID);
  void updateStopDate(int itemID, Date newStopDate);

}
