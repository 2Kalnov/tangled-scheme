package core.entity;

import core.event.NodeListener;
import core.event.TangleStateListener;
import org.jgrapht.Graph;

import java.util.Set;

public class Tangle {
  protected Graph<Node, Edge> tangleGraph;
  protected Set<TangleStateListener> listeners;
  protected int edgesCrossingCount;

  public Tangle(Graph graph) {
    this.tangleGraph = graph;
  }

  protected int calculateEdgesCrossingCount() {
    int crossesNumber = 0;

    Set<Edge> edges = tangleGraph.edgeSet();
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
}
