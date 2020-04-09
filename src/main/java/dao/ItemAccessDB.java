package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.Item;

public class ItemAccessDB implements ItemAccessibleDB {

  @Override
  public float getStartPrice(int itemID) {
    float startPrice = 0;
    //String query = "select start_price from items where item_id = ?";
    String query = "select start_price from "+DataBaseInitialization.itemsTableName+" where item_id = ?";
    try (Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
      preparedStatement.setInt(1, itemID);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        startPrice = rs.getFloat("start_price");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return startPrice;
  }

  @Override
  public void setBidAndBidderID(int bid, int bidderID, int itemID) {
    //String query = "update items set best_offer = ?, bidder = ?  where item_id = ?";
    String query = "update "+DataBaseInitialization.itemsTableName+" set best_offer = ?, bidder = ?  where item_id = ?";
    try (Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStmt = connection.prepareStatement(query)) {
      preparedStmt.setFloat(1, bid);
      preparedStmt.setInt(2, bidderID);
      preparedStmt.setInt(3, itemID);
      preparedStmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public ArrayList<Item> getAllItems() {
    //String query = "select * from items";
    String query = "select * from "+DataBaseInitialization.itemsTableName;
    ArrayList<Item> listOfItems = new ArrayList<>();
    try (Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery(query)) {
      while (rs.next()) {
        Item item = new Item();
        item.setId(rs.getInt("item_id"));
        item.setTitle(rs.getString("title"));
        item.setDescription(rs.getString("description"));
        item.setSellerId(rs.getInt("seller_id"));
        item.setStartPrice(rs.getFloat("start_price"));
        item.setBestOffer(rs.getFloat("best_offer"));
        item.setBidderId(rs.getInt("bidder"));
        item.setEndDate(rs.getDate("stop_date"));
        item.setStartDate(rs.getDate("start_date"));
        listOfItems.add(item);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return listOfItems;
  }

  @Override
  public ArrayList<Item> getMyItems(int userID) {

    //String query = "select * from items where seller_id = ?";
    String query = "select * from "+DataBaseInitialization.itemsTableName+" where seller_id = ?";
    ArrayList<Item> listOfMyItems = new ArrayList<>();

    try (Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
      preparedStatement.setInt(1, userID);
      ResultSet rs = preparedStatement.executeQuery();


      while (rs.next()) {
        Item item = new Item();
        item.setId(rs.getInt("item_id"));
        item.setTitle(rs.getString("title"));
        item.setDescription(rs.getString("description"));
        item.setStartPrice(rs.getFloat("start_price"));
        item.setBestOffer(rs.getFloat("best_offer"));
        item.setBidderId(rs.getInt("bidder"));
        item.setEndDate(rs.getDate("stop_date"));
        listOfMyItems.add(item);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return listOfMyItems;
  }

  @Override
  public float getCurrentBid(int itemID) {
    //String query = "select best_offer from items where item_id = ?";
    String query = "select best_offer from "+DataBaseInitialization.itemsTableName+" where item_id = ?";
    float currentBid = 0;
    try (Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
      preparedStatement.setInt(1, itemID);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        currentBid = rs.getFloat("best_offer");
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return currentBid;
  }

  @Override
  public void addItem(String title, String description, int sellerID, float startPrice,
      float bestOffer, int bidderId, Date endDate, Date startDate) {
//    String query = "INSERT INTO items "
//        + "VALUES(?,?,?,?,?,?,?,?,?)";
    String query = "INSERT INTO "+DataBaseInitialization.itemsTableName
        + " VALUES(?,?,?,?,?,?,?,?,?)";
    try (Connection connection = MyConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(query,
            Statement.RETURN_GENERATED_KEYS);) {
      java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
      java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
      pstmt.setInt(1, 0);
      pstmt.setString(2, title);
      pstmt.setString(3, description);
      pstmt.setInt(4, sellerID);
      pstmt.setFloat(5, startPrice);
      pstmt.setFloat(6, bestOffer);
      pstmt.setInt(7, bidderId);
      pstmt.setDate(8, sqlEndDate);
      pstmt.setDate(9, sqlStartDate);

      pstmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteItem(int itemID) {
    //String query = "delete from items where item_id = ?";
    String query = "delete from "+DataBaseInitialization.itemsTableName+" where item_id = ?";
    try (Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStmt = connection.prepareStatement(query);) {

      preparedStmt.setInt(1, itemID);
      preparedStmt.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateStopDate(int itemID, Date newStopDate) {
    //String query = "update items set stop_date = ? where item_id = ?";
    String query = "update "+DataBaseInitialization.itemsTableName+" set stop_date = ? where item_id = ?";
    try (Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStmt = connection.prepareStatement(query)) {

      java.sql.Date sqlEndDate = new java.sql.Date(newStopDate.getTime());
      preparedStmt.setDate(1, sqlEndDate);
      preparedStmt.setInt(2, itemID);

      preparedStmt.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
