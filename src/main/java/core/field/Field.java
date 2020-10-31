package core.field;

import core.entity.node.Node;
import core.entity.tangle.Tangle;
import core.field.geometry.Point;

import java.util.Set;

public class Field {
  public static int DEFAULT_FIELD_HEIGHT = 200;
  public static int DEFAULT_FIELD_WIDTH = 200;

  private int width;
  private int height;

  public Field(int width, int height) {
    this.width = width;
    this.height = height;
  }

  private Tangle tangle;

  public void setTangle(Tangle tangle) {
    this.tangle = tangle;
  }

  public Tangle getTangle() {
    return tangle;
  }

  public void moveNode(Node tangleNode, Point targetPosition)
          throws PositionOutOfFieldException, PositionOccupiedException
  {
    int targetPositionX = targetPosition.getX();
    int targetPositionY = targetPosition.getY();

    boolean underField = targetPositionY < 0;
    boolean aboveField = targetPositionY > height;
    boolean onSideOfField = targetPositionY < 0 || targetPositionY > width;
    // Проверяем, что узел хотят переместить в пределах поля
    if(underField || aboveField || onSideOfField)
      throw new PositionOutOfFieldException("Невозможно переместить узел за пределы игрового поля");

    // Проверяем, что узел хотят переместить в точку, в которой нет другого узла
    if(isPositionOccupied(targetPositionX, targetPositionY))
      throw new PositionOccupiedException("Невозможно переместить узел: позиция занята другим узлом");

    tangleNode.move(
            targetPosition.getX(), targetPosition.getY()
    );
  }

  public Node getNode(int x, int y) {
    Point nodePosition = new Point(x, y);
    Set<Node> nodes = tangle.getNodes();

    for(Node node : nodes) {
      if(node.getPosition().equals(nodePosition))
        return node;
    }

    return null;
  }

  public boolean isPositionOccupied(int x, int y) {
    return getNode(x, y) != null;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }
}
