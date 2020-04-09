package core.entity;

import core.geometry.Point;
import core.event.NodeListener;

import java.util.ArrayList;
import java.util.List;

public class Node {
  protected Point position;
  protected static int lastNodeId = 0;
  protected int id;
  protected List<NodeListener> listeners;

  public Node() {
    lastNodeId += 1;
    this.id = lastNodeId;

    this.listeners = new ArrayList<>();
  }

  public void move(double xOffset, double yOffset) {
    this.position = this.position.move(xOffset, yOffset);
  }

  protected void updateListeners() {
    for(NodeListener listener : listeners) {
      listener.update(this.id);
    }
  }
}
