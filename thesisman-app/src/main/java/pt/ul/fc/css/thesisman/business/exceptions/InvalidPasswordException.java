package pt.ul.fc.css.thesisman.business.exceptions;

public class InvalidPasswordException extends Exception {

  public InvalidPasswordException() {
  }

  public InvalidPasswordException(String message) {
    super(message);
  }

  public InvalidPasswordException(Throwable cause) {
    super(cause);
  }

  public InvalidPasswordException(String message, Throwable cause) {
    super(message, cause);
  }
}
