package core.field.geometry;

import core.entity.edge.Edge;
import core.entity.node.Node;
import core.entity.node.SimpleNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EdgeTests {
  @Test
  void moveEdgeNode() {
    Node start = new SimpleNode(1, 1);
    Node end = new SimpleNode(2, 5);
    Edge edge = new Edge(start, end);

    start.move(2, 1);
    Line movedEdgeLine = new Line(new Point(2, 1), new Point(2, 5));

    Assertions.assertEquals(movedEdgeLine, edge.getLine());
  }

  @Test
  void crossAfterMoveEdgeNode() {
    Node start = new SimpleNode(1, 1);
    Node end = new SimpleNode(3, 3);
    Edge edge = new Edge(start, end);

    Node otherStart = new SimpleNode(4, 1);
    Node otherEnd = new SimpleNode(5, 4);
    Edge otherEdge = new Edge(otherStart, otherEnd);

    otherEnd.move(2, 3);

    Assertions.assertTrue(edge.cross(otherEdge));
  }

  @Test
  void noEdgeCrossing() {
    Node start = new SimpleNode(1, 1);
    Node end = new SimpleNode(3, 3);
    Edge edge = new Edge(start, end);

    Node otherStart = new SimpleNode(4, 4);
    Node otherEnd = new SimpleNode(10, 3);
    Edge otherEdge = new Edge(otherStart, otherEnd);

    Assertions.assertFalse(edge.cross(otherEdge));
  }

}
