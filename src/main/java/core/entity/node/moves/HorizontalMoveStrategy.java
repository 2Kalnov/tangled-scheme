package core.entity.node.moves;

import core.field.geometry.Point;

public class HorizontalMoveStrategy implements MoveStrategy {
  @Override
  public Point moveTo(Point nodePosition, Point targetPosition) {
    int xOffset = targetPosition.getX() - nodePosition.getX();
    return nodePosition.move(xOffset, 0);
  }
}
