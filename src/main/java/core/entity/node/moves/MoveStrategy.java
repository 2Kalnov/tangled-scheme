package core.entity.node.moves;

import core.field.geometry.Point;

public interface MoveStrategy {
  /**
   *
   * @param nodePosition текущая позиция узла
   * @param targetPosition целевая позиция узла (куда пользователь хочет переместить узел)
   * @return новая позиция узла после попытки перемещения
   */
  Point moveTo(Point nodePosition, Point targetPosition);
}
