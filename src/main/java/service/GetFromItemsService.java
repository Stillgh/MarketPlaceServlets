package service;

import dao.ItemAccessDB;

import java.util.ArrayList;
import model.Item;

public class GetFromItemsService implements ItemsGetter {

  @Override
  public float getStartPrice(int itemID) {
    ItemAccessDB itemAccessDB = new ItemAccessDB();
    return itemAccessDB.getStartPrice(itemID);
  }

  @Override
  public ArrayList<Item> getAllItems() {
    ItemAccessDB itemAccessDB = new ItemAccessDB();
    return itemAccessDB.getAllItems();
  }

  @Override
  public ArrayList<Item> getMyItems(int userID) {
    ItemAccessDB itemAccessDB = new ItemAccessDB();
    return itemAccessDB.getMyItems(userID);
  }

  @Override
  public float getCurrentBid(int itemID) {
    ItemAccessDB itemAccessDB = new ItemAccessDB();
    return itemAccessDB.getCurrentBid(itemID);
  }

}
