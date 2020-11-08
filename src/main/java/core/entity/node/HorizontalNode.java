package core.entity.node;

import core.field.geometry.Point;

public class HorizontalNode extends Node {
  public HorizontalNode(int x, int y) {
    super(x, y);
  }

  public HorizontalNode(Point position) {
    super(position.getX(), position.getY());
  }

  @Override
  protected boolean moveTo(int targetX, int targetY) {
    int xOffset = targetX - this.position.getX();
    this.position = this.position.move(xOffset, 0);

    return xOffset != 0;
  }
}
