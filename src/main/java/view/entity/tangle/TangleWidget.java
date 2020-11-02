package view.entity.tangle;

import core.entity.tangle.Tangle;
import view.entity.edge.EdgeWidget;
import view.entity.node.NodeWidget;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Set;

public class TangleWidget extends JPanel {
  private Tangle tangle;
  private final Set<NodeWidget> nodes;
  private final Set<EdgeWidget> edges;

  TangleWidget(Set<NodeWidget> nodes, Set<EdgeWidget> edges, Tangle tangle) {
    this.nodes = nodes;
    this.edges = edges;
  }

  public Set<NodeWidget> getNodes() {
    return Collections.unmodifiableSet(nodes);
  }

  public Set<EdgeWidget> getEdges() {
    return Collections.unmodifiableSet(edges);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
  }
}
