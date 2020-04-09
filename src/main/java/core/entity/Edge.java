package core.entity;

import core.event.NodeListener;
import core.geometry.Line;

public class Edge implements NodeListener {
  private Node start;
  private Node end;

  private Line line;

  public Edge(Node start, Node end) {
    this.start = start;
    this.end = end;

    this.line = new Line(start.position, end.position);
  }

  public Line getLine() {
    return this.line;
  }

  public boolean cross(Edge otherEdge) {
    return line.cross(otherEdge.line);
  }

  @Override
  public void update(int nodeId) {

  }
}
