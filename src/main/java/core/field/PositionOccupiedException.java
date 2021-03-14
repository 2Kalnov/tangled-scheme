package core.field;

public class PositionOccupiedException extends Exception {
  public PositionOccupiedException() {
    super("Данная позиция поля занята другим объектом");
  }

  public PositionOccupiedException(String message) {
    super(message);
  }
}
