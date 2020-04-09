package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {


  public static Connection getConnection() throws SQLException {
    Connection con = null;
    try{
      final String USERNAME = "root";
      final String PASSWORD = "admin";
      Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//      con=DriverManager.getConnection(
//          "jdbc:mysql://localhost:3306/marketplacedb?characterEncoding=UTF-8&useUnicode=true&serverTimezone=UTC",USERNAME,PASSWORD);

      con=DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/"+DataBaseInitialization.dbName+"?characterEncoding=UTF-8&useUnicode=true&serverTimezone=UTC",USERNAME,PASSWORD);

    }catch(Exception e){ System.out.println(e);}
    return con;
  }

  public void closeConnection(Connection connection) throws SQLException {
    connection.close();
  }


}
