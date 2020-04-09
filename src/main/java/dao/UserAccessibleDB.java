package dao;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import model.User;

public interface UserAccessibleDB {

  ArrayList<User> getAllUsers();
  User getUserByID(int id);
  void addUser(String name, String address, String email, String login, String password);
  int findUserID(String userName);
  AtomicBoolean loginValidity(String login, String password);
  boolean isLoginExists(String login);

}
