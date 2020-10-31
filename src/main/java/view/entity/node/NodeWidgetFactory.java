package view.entity.node;

import core.entity.node.Node;

import java.awt.*;

public class NodeWidgetFactory {
  private static Color SIMPLE_NODE_COLOR = Color.getHSBColor(217, 24, 61);
  private static Color STATIC_NODE_COLOR = Color.getHSBColor(13, 83, 75);
  private static Color VERTICAL_NODE_COLOR = Color.getHSBColor(68, 83, 75);
  private static Color HORIZONTAL_NODE_COLOR = Color.getHSBColor(287, 43, 87);

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
