package service;


import java.util.ArrayList;
import model.User;

public interface UsersGetter {
  ArrayList<User> getAllUsers();
  User getUserByID(int id);
  int findUserID(String userName);
}
