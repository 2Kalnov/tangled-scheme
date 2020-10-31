package core.entity.tangle.factory;

import core.entity.edge.Edge;
import core.entity.node.Node;
import core.entity.tangle.Tangle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NineCrossingsTangleFactory implements TangleFactory {
  private final static int TANGLE_WIDTH = 700;
  private final static int TANGLE_HEIGHT = 500;

  @Override
  public Tangle getTangle() {
    Node firstNode = new Node(6, 13);
    Node secondNode = new Node(9, 3);
    Node thirdNode = new Node(28, 4);
    Node fourthNode = new Node(31,13);
    Node fifthNode = new Node(16, 32);
    Node sixthNode = new Node(19, 22);
    Node seventhNode = new Node(18, 14);
    Node eighthNode = new Node(11, 13);
    Node ninthNode = new Node(12, 24);
    Node tenthNode = new Node(8, 28);

    Set<Node> nodes = new HashSet<>();
    nodes.addAll(Arrays.asList(
       firstNode, secondNode, thirdNode, fourthNode, fifthNode, sixthNode, seventhNode, eighthNode, ninthNode, tenthNode
    ));

    Set<Edge> edges = new HashSet<>();
    edges.addAll(Arrays.asList(
            new Edge(firstNode, secondNode),
            new Edge(firstNode, sixthNode),
            new Edge(firstNode, ninthNode),
            new Edge(secondNode, thirdNode),
            new Edge(secondNode, fourthNode),
            new Edge(secondNode, tenthNode),
            new Edge(thirdNode, eighthNode),
            new Edge(fourthNode, fifthNode),
            new Edge(fifthNode, seventhNode),
            new Edge(fifthNode, eighthNode),
            new Edge(sixthNode, tenthNode),
            new Edge(seventhNode, ninthNode)
    ));

    return new Tangle(nodes, edges);
  }

  @Override
  public int getWidth() {
    return TANGLE_WIDTH;
  }

  @Override
  public int getHeight() {
    return TANGLE_HEIGHT;
  }
}
