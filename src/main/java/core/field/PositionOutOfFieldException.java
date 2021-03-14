package core.field;

public class PositionOutOfFieldException extends Exception {
  public PositionOutOfFieldException() {
    super("Позиция точки находится за пределами поля");
  }

  public PositionOutOfFieldException(String message) {
    super(message);
  }
}
