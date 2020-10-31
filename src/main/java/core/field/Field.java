package core.field;

import core.entity.node.Node;
import core.entity.tangle.Tangle;
import core.field.geometry.Point;

import java.util.Set;

public class Field {
  private double width;
  private double height;

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
    double targetPositionX = targetPosition.getX();
    double targetPositionY = targetPosition.getY();

    boolean underField = targetPositionY < 0;
    boolean aboveField = targetPositionY > height;
    boolean onSideOfField = targetPositionY < 0 || targetPositionY > width;
    // Проверяем, что узел хотят переместить в пределах поля
    if(underField || aboveField || onSideOfField)
      throw new PositionOutOfFieldException("Невозможно переместить узел за пределы игрового поля");

    // Проверяем, что узел хотят переместить в точку, в которой нет другого узла
    if(isPositionOccupied(targetPositionX, targetPositionY))
      throw new PositionOccupiedException("Невозможно переместить узел: позиция занята другим узлом");

    Set<Node> nodes = tangle.getNodes();
    boolean successfulMove = false;

    for(Node node : nodes) {
      Point nodePosition = node.getPosition();

  public boolean isPositionOccupied(double x, double y) {
    return getNode(x, y) != null;
  }

      successfulMove = true;
    }

    return successfulMove;
  }
}
