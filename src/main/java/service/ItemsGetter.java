package service;

import java.util.ArrayList;
import model.Item;

public interface ItemsGetter {

   float getStartPrice (int itemID) ;
   ArrayList<Item> getAllItems();
   ArrayList<Item> getMyItems(int userID );
   float getCurrentBid(int itemID);

}
