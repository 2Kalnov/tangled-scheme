package view.entity.node;

import core.entity.node.*;

import java.awt.*;

public class NodeWidgetFactory {
  private static Color SIMPLE_NODE_COLOR = new Color(66, 86, 184);
  private static Color STATIC_NODE_COLOR = new Color(153, 65, 49);
  private static Color VERTICAL_NODE_COLOR = new Color(219, 219, 158);
  private static Color HORIZONTAL_NODE_COLOR = new Color(165, 217, 200);

  // TODO сделать один публичный метод; в нём определять фактический тип узла и возвращать узел нужного цвета

  /**
   * Получение соответствующего виджета узла в зависимости от типа узла
   * @param node узел
   * @return виджет узла определённого цвета
   */
  public static NodeWidget getNode(Node node) {
    return new NodeWidget(node, SIMPLE_NODE_COLOR);
  }

  private static Color getNodeColor(Node node) {
    if(node instanceof SimpleNode)
      return SIMPLE_NODE_COLOR;
    else if(node instanceof StaticNode)
      return STATIC_NODE_COLOR;
    else if(node instanceof VerticalNode)
      return VERTICAL_NODE_COLOR;
    else if(node instanceof HorizontalNode)
      return HORIZONTAL_NODE_COLOR;
    else
      return SIMPLE_NODE_COLOR;
  }
}
