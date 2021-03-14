package core.field;

public class NodeNotFoundException extends Exception {
  public NodeNotFoundException() {
    super("Невозможно найти узел с заданными координатами");
  }
}
