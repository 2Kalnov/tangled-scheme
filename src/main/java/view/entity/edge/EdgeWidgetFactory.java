package view.entity.edge;

import core.entity.edge.Edge;

import java.awt.*;

public class EdgeWidgetFactory {
  private static Color CROSSED_EDGE_COLOR = new Color(191, 43, 10);
  private static Color UNTANGLED_EDGE_COLOR = new Color(141, 245, 66);

  public static EdgeWidget getEdge(Edge edge, boolean isCrossed) {
    return new EdgeWidget(edge, getEdgeColor(isCrossed));
  }

  private static Color getEdgeColor(boolean isCrossed) {
    Color color;

    if(isCrossed)
      color = CROSSED_EDGE_COLOR;
    else
      color = UNTANGLED_EDGE_COLOR;

    return color;
  }

  public static void colorize(EdgeWidget edge, boolean isCrossed) {
    edge.setColor(getEdgeColor(isCrossed));
  }
}
