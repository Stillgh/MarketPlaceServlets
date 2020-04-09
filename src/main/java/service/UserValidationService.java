package service;


import dao.UserAccessDB;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserValidationService implements UserValidator {

  @Override
  public AtomicBoolean loginValidity(String login, String password) {
    UserAccessDB userAccessDB = new UserAccessDB();
    return userAccessDB.loginValidity(login, password);
  }

  @Override
  public boolean isLoginExists(String login) {
    UserAccessDB userAccessDB = new UserAccessDB();
    return userAccessDB.isLoginExists(login);
  }
}
