package view.entity.tangle;

import core.entity.edge.Edge;
import core.entity.node.Node;
import core.entity.tangle.Tangle;
import view.entity.edge.EdgeWidget;
import view.entity.edge.EdgeWidgetFactory;
import view.entity.node.NodeWidget;
import view.entity.node.NodeWidgetFactory;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TangleWidgetFactory {
  public static TangleWidget getTangle(Tangle tangle) {
    Set<NodeWidget> nodes = new HashSet<>();
    Set<EdgeWidget> edges = new HashSet<>();

    // Создаём узлы клубка
    for(Node node : tangle.getNodes())
      nodes.add(NodeWidgetFactory.getNode(node));

    // Создаём рёбра клубка
    for(Map.Entry<Edge, Boolean> entanglement : tangle.getEdgesEntanglement().entrySet()) {
      Edge edge = entanglement.getKey();
      boolean isCrossed = entanglement.getValue();

      edges.add(EdgeWidgetFactory.getEdge(edge, isCrossed));
    }

    return new TangleWidget(nodes, edges, tangle);
  }
}
