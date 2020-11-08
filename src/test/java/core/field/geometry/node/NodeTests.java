package core.field.geometry.node;

import core.entity.node.Node;
import core.entity.node.SimpleNode;
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


}
