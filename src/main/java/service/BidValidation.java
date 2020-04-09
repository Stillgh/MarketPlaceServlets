package service;

import dao.ItemAccessDB;

public class BidValidation {

  public static boolean validateBid(int itemID, float bid) {


    ItemAccessDB itemAccessDB = new ItemAccessDB();
    float startPrice = itemAccessDB.getStartPrice(itemID);
    float currentBid = itemAccessDB.getCurrentBid(itemID);
    return (bid>startPrice && bid>currentBid);
  }

}
