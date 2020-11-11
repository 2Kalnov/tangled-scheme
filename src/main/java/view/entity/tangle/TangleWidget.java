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
    setLayout(null);
    addNodes();
  }

  public Set<NodeWidget> getNodes() {
    return Collections.unmodifiableSet(nodes);
  }

  public Set<EdgeWidget> getEdges() {
    return Collections.unmodifiableSet(edges);
  }

  private void addNodes() {
    for(NodeWidget node : nodes)
      add(node);
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

    Graphics2D g2d = (Graphics2D)g;

    // Задание границ узлов
    for(NodeWidget node : nodes) {
      int nodeSize = node.getSize().width;

      core.field.geometry.Point nodePosition = node.getPosition();
      int x = nodePosition.getX();
      int y = nodePosition.getY();
      // node.setBounds(x - nodeSize / 2, y - nodeSize / 2, nodeSize, nodeSize);
      node.setBounds(x - nodeSize / 2, y - nodeSize / 2, nodeSize, nodeSize);
    }

    // Отрисовка рёбер, которые не кликабельны и могут не добавляться в контейнер (поле) отдельно
    for(EdgeWidget edge : edges) {
      // Рёбра отрисовываются на том же холсте; рёбра не являются виджетами!
      edge.paint(g2d);
    }
  }
}
