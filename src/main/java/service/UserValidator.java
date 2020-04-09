package service;

import java.util.concurrent.atomic.AtomicBoolean;

public interface UserValidator {
  AtomicBoolean loginValidity(String login, String password);
  boolean  isLoginExists(String login);
}
