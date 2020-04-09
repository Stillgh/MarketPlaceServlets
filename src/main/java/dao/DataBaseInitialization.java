package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseInitialization {
  static String dbName = "marketdb";
  public static String usersTableName = "userstable";
  static String itemsTableName = "itemstable";

  public static Connection createConnection(){

    String port = "3306";
    Connection con = null;
    try{
      final String USERNAME = "root";
      final String PASSWORD = "admin";
      Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

      con= DriverManager.getConnection(
          "jdbc:mysql://localhost:" + port + "/?characterEncoding=UTF-8&useUnicode=true&serverTimezone=UTC",USERNAME,PASSWORD);
      System.out.println("success0");

    }catch(Exception e){ System.out.println(e);}
    return con;
  }


  public static void createSchema(){



    try (Connection connection = createConnection();
        Statement stmt = connection.createStatement()){
      String sql = "CREATE DATABASE "+ dbName;
      stmt.executeUpdate(sql);

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public static void createUserTable(){
    String query = "CREATE TABLE `" + dbName + "`.`" + usersTableName + "` (\n"
        + "  `user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\n"
        + "  `name` VARCHAR(50) NOT NULL,\n"
        + "  `address` VARCHAR(50) NOT NULL,\n"
        + "  `email` VARCHAR(50) NULL DEFAULT NULL,\n"
        + "  `login` VARCHAR(50) NULL DEFAULT NULL,\n"
        + "  `password` VARCHAR(50) NULL DEFAULT NULL,\n"
        + "        PRIMARY KEY (`user_id`),\n"
        + "        UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,\n"
        + "        UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE)";

    try (Connection connection = createConnection();
        Statement stmt = connection.createStatement()){
      stmt.execute(query);
      System.out.println("success1");
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

  }

  public static void createItemsTable(){
    String query = "CREATE TABLE `" + dbName + "`.`"+ itemsTableName +"` (\n"
        + "  `item_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\n"
        + "  `title` VARCHAR(50) NOT NULL,\n"
        + "  `description` VARCHAR(250) NOT NULL,\n"
        + "  `seller_id` INT UNSIGNED NOT NULL,\n"
        + "  `start_price` FLOAT NOT NULL,\n"
        + "  `best_offer` FLOAT NULL DEFAULT NULL,\n"
        + "  `bidder` INT NULL DEFAULT NULL,\n"
        + "  `stop_date` DATE NULL DEFAULT NULL,\n"
        + "  `start_date` DATE NULL DEFAULT NULL,\n"
        + "  PRIMARY KEY (`item_id`),\n"
        + "  UNIQUE INDEX `item_id_UNIQUE` (`item_id` ASC) VISIBLE,\n"
        + "  INDEX `item_id_idx` (`seller_id` ASC) VISIBLE,\n"
        + "  CONSTRAINT `sellerid`\n"
        + "    FOREIGN KEY (`seller_id`)\n"
        + "    REFERENCES `marketdb`.`userstable` (`user_id`)\n"
        + "    ON DELETE CASCADE\n"
        + "    ON UPDATE RESTRICT);";

    try (Connection connection = createConnection();
        Statement stmt = connection.createStatement()){
      stmt.execute(query);
      System.out.println("success3");
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public static void fillUsersTable(){
    String query = "INSERT INTO "+ dbName + "."+usersTableName+" VALUES \n"
        + "(null, 'Leha','Saratov','sanek@mail.com','lehalog','Sanek228'),\n"
        + "(null, 'Andrei', 'Moscow', 'andrei@mail.com', 'andreilog', 'Andrei228'),\n"
        + "(null, 'John', 'LA', 'john@mail.com', 'johnlog', 'John228'),\n"
        + "(null, 'Bob', 'Detroit', 'bob@mail.com', 'boblog', 'Bob228');";
    try (Connection connection = createConnection();
        Statement stmt = connection.createStatement()){
      stmt.execute(query);
      System.out.println("success4");
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public static void fillItemsTable(){
      String query = "INSERT INTO "+ dbName + "."+itemsTableName+" VALUES \n"
          + "(null, 'cat','cool cat', '1', '100','0','0', null, null),\n"
          + "(null, 'dog','cool dog', '2', '150','0','0', null, null),\n"
          + "(null, 'fish','cool fish', '3', '75','0','0', null, null);";
    try (Connection connection = createConnection();
        Statement stmt = connection.createStatement()){
      stmt.execute(query);
      System.out.println("success5");
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }


  //выполняется если невалидную ставку попытаться поставить на товар (в ItemsServlet код)
  public static void dropDataBase(){
    String query = "\t\n"
        + "DROP DATABASE " + dbName+";";
    try (Connection connection = createConnection();
        Statement stmt = connection.createStatement()){
      stmt.execute(query);
      System.out.println("success7");
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

  }


  //инициализируется при залогинивании на сайт(в myServlet код)
  static {
    createSchema();
    createUserTable();
    createItemsTable();
    fillUsersTable();
    fillItemsTable();
    System.out.println("success2");

  }
}
