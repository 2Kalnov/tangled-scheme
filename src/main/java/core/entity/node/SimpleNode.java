package core.entity.node;

import core.field.geometry.Point;

public class SimpleNode extends Node {
  public SimpleNode(Point nodePosition) {
    super(nodePosition.getX(), nodePosition.getY());
  }

  public SimpleNode(int x, int y) {
    super(x, y);
  }

  @Override
  protected boolean moveTo(int targetX, int targetY) {
    int xOffset, yOffset;
    xOffset = targetX - this.position.getX();
    yOffset = targetY - this.position.getY();

    this.position = this.position.move(xOffset, yOffset);
    return xOffset != 0 || yOffset != 0;
  }

  @Override
  public String toString() {
    return "Обычный узел: " + position.toString();
  }
}
