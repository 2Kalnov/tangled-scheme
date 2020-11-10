package core.entity.tangle;

import core.entity.edge.Edge;
import core.entity.node.Node;
import core.event.NodeListener;
import core.event.TangleStateListener;

import java.util.*;

public class Tangle implements NodeListener {
  private Set<Node> nodes;
  private Set<Edge> edges;
  private Map<Edge, Boolean> edgesEntanglement;

  private Set<TangleStateListener> listeners;
  private int edgesCrossingCount;

  public Tangle(Set<Node> nodes, Set<Edge> edges) {
    this.edges = new HashSet<>();
    this.edges.addAll(edges);

    this.nodes = new HashSet<>();
    this.nodes.addAll(nodes);

    this.listeners = new HashSet<>();
    edgesEntanglement = new HashMap<>();
    
    this.edgesCrossingCount = calculateEdgesCrossingCount();

    // Клубок реагирует на изменение любой точки в нём
    for(Node node : this.nodes) {
      node.addListener(this);
    }
  }

  protected int calculateEdgesCrossingCount() {
    int crossesNumber = 0;

    for(Edge edge : edges) {
      boolean isCrossed = false;
      for(Edge otherEdge : edges) {
        if(edge.cross(otherEdge)) {
          crossesNumber += 1;
          isCrossed = true;
        }
      }

      edgesEntanglement.put(edge, isCrossed);
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

  public Map<Edge, Boolean> getEdgesEntanglement() {
    return Collections.unmodifiableMap(this.edgesEntanglement);
  }

  @Override
  public void nodeChanged() {
    edgesCrossingCount = calculateEdgesCrossingCount();
    fireTangleChangedEvent();
  }

  private void fireTangleChangedEvent() {

    for (TangleStateListener listener : listeners) {
      listener.tangleStateChanged(edgesCrossingCount);
    }
  }
}
