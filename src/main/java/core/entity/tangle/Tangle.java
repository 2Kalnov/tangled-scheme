package core.entity;

import core.entity.edge.Edge;
import core.entity.node.Node;
import core.event.NodeListener;
import core.event.TangleStateListener;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Tangle implements NodeListener {
  private Set<Node> nodes;
  private Set<Edge> edges;

  private Set<TangleStateListener> listeners;
  private int edgesCrossingCount;

  public Tangle(Set<Node> nodes, Set<Edge> edges) {
    this.edges = new HashSet<>();
    this.edges.addAll(edges);

    this.nodes = new HashSet<>();
    this.nodes.addAll(nodes);

    // Клубок реагирует на изменение любой точки в нём
    for(Node node : this.nodes) {
      node.addListener(this);
    }
  }

  protected int calculateEdgesCrossingCount() {
    int crossesNumber = 0;

    for(Edge edge : edges) {
      for(Edge otherEdge : edges) {
        if(edge.cross(otherEdge))
          crossesNumber += 1;
      }
    }

    return crossesNumber / 2;
  }

  public void addListener(TangleStateListener listener) {
    if(listener != null && !listeners.contains(listener))
      listeners.add(listener);
  }

  public int getEdgesCrossingCount() {
    return this.edgesCrossingCount;
  }

  public Set<Edge> getEdges() {
    return Collections.unmodifiableSet(this.edges);
  }

  public Set<Node> getNodes() {
    return Collections.unmodifiableSet(this.nodes);
  }

  @Override
  public void update() {
    edgesCrossingCount = calculateEdgesCrossingCount();
    fireTangleChangedEvent();
  }

  private void fireTangleChangedEvent() {

    for (TangleStateListener listener : listeners) {
      listener.update();
    }
  }
}
