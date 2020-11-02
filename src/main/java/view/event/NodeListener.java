package view.event;

import core.entity.node.Node;
import core.field.geometry.Point;

public interface NodeListener {
  /**
   * Вызывается узлом при перемещении мыши (mouseDragged)
   */
  void nodeMoved(Node node, Point targetPosition);

  /**
   * Вызывается узлом при отпускании кнопки мыши (mouseReleased)
   */
  void nodePlaced();
}
