package service;

import dao.UserAccessDB;
import java.util.ArrayList;
import model.User;

public class GetFromUsersService implements UsersGetter {

  @Override
  public ArrayList<User> getAllUsers() {
    UserAccessDB userAccessDB = new UserAccessDB();
    return userAccessDB.getAllUsers();
  }

  @Override
  public User getUserByID(int id) {
    UserAccessDB userAccessDB = new UserAccessDB();
    return userAccessDB.getUserByID(id);
  }

  @Override
  public int findUserID(String userName) {
    UserAccessDB userAccessDB = new UserAccessDB();
    return userAccessDB.findUserID(userName);
  }


}
