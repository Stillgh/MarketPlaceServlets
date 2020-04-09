package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import model.User;

public class UserAccessDB implements UserAccessibleDB {


  @Override
  public ArrayList<User> getAllUsers() {
    ArrayList<User> listOfUsers = new ArrayList<>();


    //String query = "select * from users";
    String query = "select * from "+DataBaseInitialization.itemsTableName;

    try (Connection connection = MyConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query)) {
      while (rs.next()) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        user.setAddress(rs.getString("address"));
        user.setEmail(rs.getString("email"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        listOfUsers.add(user);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return listOfUsers;
  }

  @Override
  public User getUserByID(int id) {
    //String query = "select * from users where user_id = ?";
    String query = "select * from "+DataBaseInitialization.usersTableName+" where user_id = ?";
    User user = null;

    try (Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      user = new User();
      if (rs.next()) {
        user.setId(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        user.setAddress(rs.getString("address"));
        user.setEmail(rs.getString("email"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public void addUser(String name, String address, String email, String login, String password) {
//    String query = "INSERT INTO users "
//        + "VALUES(?,?,?,?,?,?)";
    String query = "INSERT INTO "+DataBaseInitialization.usersTableName
        + " VALUES(?,?,?,?,?,?)";

    try (Connection connection = MyConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(query,
            Statement.RETURN_GENERATED_KEYS)) {
      pstmt.setInt(1, 0);
      pstmt.setString(2, name);
      pstmt.setString(3, address);
      pstmt.setString(4, email);
      pstmt.setString(5, login);
      pstmt.setString(6, password);

      pstmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  @Override
  public int findUserID(String userName) {
//    String query = "select user_id from users where login = ?";
    String query = "select user_id from "+DataBaseInitialization.usersTableName+" where login = ?";
    int id = 0;

    try (Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

      preparedStatement.setString(1, userName);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        id = rs.getInt("user_id");
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return id;
  }

  @Override
  public AtomicBoolean loginValidity(String login, String password) {

    //String query = "select login, password from users";
    String query = "select login, password from "+DataBaseInitialization.usersTableName;
    AtomicBoolean isValid = new AtomicBoolean(false);
    try (Connection connection = MyConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);) {
      HashMap<String, String> loginPassword = new HashMap<>();

      while (rs.next()) {
        loginPassword.put(rs.getString("login"), rs.getString("password"));
      }

      loginPassword.forEach((k, v) -> {
        if (login.equals(k)) {
          if (password.equals(v)) {
            isValid.set(true);
          }
        }
      });

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return isValid;
  }

  @Override
  public boolean isLoginExists(String login){
    //String query = "select login from users";
    String query = "select login from "+ DataBaseInitialization.usersTableName;
    boolean isUsed = false;

    try (Connection connection = MyConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);) {

      ArrayList<String> listOfLogins = new ArrayList<>();

      while (rs.next()) {
        listOfLogins.add(rs.getString("login"));
      }

      for (String userLogin : listOfLogins) {
        if (login.equals(userLogin)) {
          isUsed = true;
          break;
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return isUsed;
  }
}
