package view.entity.tangle;

import core.entity.edge.Edge;
import core.entity.tangle.Tangle;
import core.event.TangleStateListener;
import view.entity.edge.EdgeWidget;
import view.entity.edge.EdgeWidgetFactory;
import view.entity.node.NodeWidget;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class TangleWidget extends JPanel implements TangleStateListener {
  private Tangle tangle;
  private final Set<NodeWidget> nodes;
  private final Set<EdgeWidget> edges;

  TangleWidget(Set<NodeWidget> nodes, Set<EdgeWidget> edges, Tangle tangle) {
    this.nodes = nodes;
    this.edges = edges;
    this.tangle = tangle;

    tangle.addListener(this);
  }

  public Set<NodeWidget> getNodes() {
    return Collections.unmodifiableSet(nodes);
  }

  public Set<EdgeWidget> getEdges() {
    return Collections.unmodifiableSet(edges);
  }

  @Override
  public void tangleStateChanged(int crossingCount) {
    Map<Edge, Boolean> edgesEntanglement = tangle.getEdgesEntanglement();

    for(EdgeWidget edge : edges) {
      boolean isCrossed = edgesEntanglement.get(edge.getEdge());
      EdgeWidgetFactory.colorize(edge, isCrossed);
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
  }
}
