package service;

import dao.ItemAccessDB;
import java.util.Date;

public class UpdateItemsService implements ItemsUpdater {
  @Override
  public void setBidAndBidderID(int bid, int bidderID, int itemID) {
    ItemAccessDB itemAccessDB = new ItemAccessDB();
    itemAccessDB.setBidAndBidderID(bid, bidderID, itemID);
  }
  @Override
  public void addItem(String title, String description, int sellerID, float startPrice, float bestOffer, int bidderId, Date endDate, Date startDate) {
    ItemAccessDB itemAccessDB = new ItemAccessDB();
    itemAccessDB.addItem(title, description, sellerID, startPrice, bestOffer, bidderId, endDate, startDate);
  }
  @Override
  public void deleteItem(int itemID) {
    ItemAccessDB itemAccessDB = new ItemAccessDB();
    itemAccessDB.deleteItem(itemID);
  }
  @Override
  public void updateStopDate(int itemID, Date newStopDate){
    ItemAccessDB itemAccessDB = new ItemAccessDB();
    itemAccessDB.updateStopDate(itemID, newStopDate);
  }

}
