package view.entity.edge;

import core.entity.edge.Edge;

import java.awt.*;

public class EdgeWidgetFactory {
  private static Color CROSSED_EDGE_COLOR = new Color(191, 43, 10);
  private static Color UNTANGLED_EDGE_COLOR = new Color(11, 87, 40);

  public static EdgeWidget getEdge(Edge edge, boolean isCrossed) {
    Color edgeColor;
    if(isCrossed)
      edgeColor = UNTANGLED_EDGE_COLOR;
    else
      edgeColor = CROSSED_EDGE_COLOR;

    return new EdgeWidget(edge, edgeColor);
  }
}
