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

  }
}
