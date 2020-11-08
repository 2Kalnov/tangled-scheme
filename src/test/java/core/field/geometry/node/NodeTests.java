package core.field.geometry.node;

import core.entity.node.*;
import core.field.geometry.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class NodeTests {
  @Test
  void moveNode() {
    Node node = new SimpleNode(3, 4);
    node.move(4, 5);

    Node movedNode = new SimpleNode(4, 5);

    Assertions.assertEquals(node.getPosition(), movedNode.getPosition());
  }

  @Test
  void moveStaticNode() {
    Point nodePosition = new Point(2, 2);
    Node node = new StaticNode(nodePosition);
    node.move(4, 4);

    Assertions.assertEquals(node.getPosition(), nodePosition);
  }


  @Test
  void moveVerticalNode() {
    Point nodePosition = new Point(2, 2);
    Node node = new VerticalNode(nodePosition);

    Point targetPosition = new Point(4, 4);
    node.move(targetPosition.getX(), targetPosition.getY());

    int yOffset = targetPosition.getY() - nodePosition.getY();

    Assertions.assertEquals(node.getPosition(), new Point(nodePosition.getX(), nodePosition.getY() + yOffset));
  }

  @Test
  void moveHorizontalNode() {
    Point nodePosition = new Point(2, 2);
    Node node = new HorizontalNode(nodePosition);

    Point targetPosition = new Point(4, 4);
    node.move(targetPosition.getX(), targetPosition.getY());

    int xOffset = targetPosition.getX() - nodePosition.getX();

    Assertions.assertEquals(node.getPosition(), new Point(nodePosition.getX() + xOffset, nodePosition.getY()));
  }
}
