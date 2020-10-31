package core.field.geometry;

import core.entity.node.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class NodeTests {
  @Test
  void moveNode() {
    Node node = new Node(3, 4);
    node.move(4, 5);

    Node movedNode = new Node(4, 5);

    Assertions.assertEquals(node.getPosition(), movedNode.getPosition());
  }


}
