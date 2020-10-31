package core.entity.edge;

import core.entity.node.Node;
import core.event.NodeListener;
import core.field.geometry.Line;

public class Edge implements NodeListener {
  private Node start;
  private Node end;
  private Line line;

  public Edge(Node start, Node end) {
    this.start = start;
    this.end = end;

    this.line = new Line(start.getPosition(), end.getPosition());

    this.start.addListener(this);
    this.end.addListener(this);
  }

  public Line getLine() {
    return this.line;
  }

  public boolean cross(Edge otherEdge) {
    return line.cross(otherEdge.line);
  }

  @Override
  public void nodeChanged() {
    this.line = new Line(start.getPosition(), end.getPosition());
  }

  @Override
  public int hashCode() {
    return this.line.hashCode();
  }

  @Override
  public boolean equals(Object otherObject) {
    if(otherObject != null && otherObject instanceof Edge) {
      Edge otherEdge = (Edge)otherObject;

      return this.line.equals(otherEdge.line);
    }
    else return false;
  }

  @Override
  public String toString() {
    return this.line.toString();
  }
}
