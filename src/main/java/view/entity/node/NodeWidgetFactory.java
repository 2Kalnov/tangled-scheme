package view.entity.node;

import core.entity.node.Node;

import java.awt.*;

public class NodeWidgetFactory {
  private static Color SIMPLE_NODE_COLOR = new Color(66, 86, 184);
  private static Color STATIC_NODE_COLOR = new Color(153, 65, 49);
  private static Color VERTICAL_NODE_COLOR = new Color(219, 219, 158);
  private static Color HORIZONTAL_NODE_COLOR = new Color(165, 217, 200);

  public static NodeWidget getSimpleNodeWidget(Node node) {
    return new NodeWidget(node, SIMPLE_NODE_COLOR);
  }

  public static NodeWidget getStaticNodeWidget(Node node) {
    return new NodeWidget(node, STATIC_NODE_COLOR);
  }

  public static NodeWidget getVerticalNodeWidget(Node node) {
    return new NodeWidget(node, VERTICAL_NODE_COLOR);
  }

  public static NodeWidget getHorizontalNodeWidget(Node node) {
    return new NodeWidget(node, HORIZONTAL_NODE_COLOR);
  }
}
