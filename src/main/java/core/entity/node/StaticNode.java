package core.entity.node;

import core.field.geometry.Point;

public class StaticNode extends Node {
  public StaticNode(int x, int y) {
    super(x, y);
  }

  public StaticNode(Point position) {
    super(position.getX(), position.getY());
  }

  @Override
  protected boolean moveTo(int targetX, int targetY) {
    return false;
  }
}
