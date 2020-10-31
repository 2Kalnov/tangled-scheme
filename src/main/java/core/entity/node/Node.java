package core.entity.node;

import core.field.geometry.Point;
import core.event.NodeListener;

import java.util.ArrayList;
import java.util.List;

public class Node {
  protected Point position;
  protected static int lastNodeId = 0;
  protected int id;
  protected List<NodeListener> listeners;

  private Node() {
    lastNodeId += 1;
    this.id = lastNodeId;

    this.listeners = new ArrayList<>();
  }

  public Node(Point nodePosition) {
    this();

    this.position = new Point(nodePosition.getX(), nodePosition.getY());
  }

  public Node(int x, int y) {
    this();

    this.position = new Point(x, y);
  }

  /**
   * @param targetX абсцисса точки, в которую необходимо переместить узел
   * @param targetY ордината точки, в которую необходимо переместить узел
   * @return узел изменил своё положение
   */
  protected boolean moveTo(int targetX, int targetY) {
    int xOffset, yOffset;
    xOffset = targetX - this.position.getX();
    yOffset = targetY - this.position.getY();

    this.position = this.position.move(xOffset, yOffset);
    return xOffset != 0 || yOffset != 0;
  }

  public void move(int targetX, int targetY) {
    boolean moved = moveTo(targetX, targetY);
    if(moved)
      fireMoveEvent();
  }

  protected void fireMoveEvent() {
    for(NodeListener listener : listeners) {
      listener.nodeChanged();
    }
  }

  public void addListener(NodeListener listener) {
    if(listener != null && !listeners.contains(listener))
      listeners.add(listener);
  }

  public Point getPosition() {
    return position;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public int hashCode() {
    return position.hashCode();
  }

  @Override
  public boolean equals(Object otherObject) {
    if(otherObject != null && otherObject instanceof Node) {
      Node otherNode = (Node)otherObject;

      return otherNode.position.equals(this.position) && otherNode.id == this.id;
    }
    else return false;
  }
}
