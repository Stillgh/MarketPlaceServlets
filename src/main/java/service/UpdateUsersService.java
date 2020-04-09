package service;

import dao.UserAccessDB;

public class UpdateUsersService implements UsersUpdater{
  @Override
  public void addUser(String name, String address, String email, String login, String password) {
    UserAccessDB userAccessDB = new UserAccessDB();
    userAccessDB.addUser(name, address, email, login, password);
  }

}
