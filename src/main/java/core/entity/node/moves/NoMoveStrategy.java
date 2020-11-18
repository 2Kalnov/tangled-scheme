package core.entity.node.moves;

import core.field.geometry.Point;

public class NoMoveStrategy implements MoveStrategy {
  @Override
  public Point moveTo(Point nodePosition, Point targetPosition) {
    return new Point(nodePosition.getX(), nodePosition.getY());
  }
}
