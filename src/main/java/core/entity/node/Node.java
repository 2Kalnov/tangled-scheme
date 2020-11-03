package core.entity.node;

import core.field.geometry.Point;
import core.event.NodeListener;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {
  protected Point position;
  protected List<NodeListener> listeners = new ArrayList<>();

  public Node(int x, int y) {
    this.position = new Point(x, y);
  }

  /**
   * @param targetX абсцисса точки, в которую необходимо переместить узел
   * @param targetY ордината точки, в которую необходимо переместить узел
   * @return узел изменил своё положение
   */
  protected abstract boolean moveTo(int targetX, int targetY);

  public void move(int targetX, int targetY) {
    boolean moved = moveTo(targetX, targetY);
    if(moved)
      fireMoveEvent();
  }

  protected abstract void fireMoveEvent();

  public void addListener(NodeListener listener) {
    if(listener != null && !listeners.contains(listener))
      listeners.add(listener);
  }

  public Point getPosition() {
    return position;
  }

  @Override
  public int hashCode() {
    return position.hashCode();
  }

  @Override
  public boolean equals(Object otherObject) {
    if(otherObject != null && otherObject instanceof Node) {
      Node otherNode = (Node)otherObject;

      return otherNode.position.equals(this.position);
    }
    else return false;
  }
}
