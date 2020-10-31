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
    Node firstNode = new Node(3.1, 6.4);
    Node secondNode = new Node(4.7, 1.8);
    Node thirdNode = new Node(14.2, 2);
    Node fourthNode = new Node(15.6,6.6);
    Node fifthNode = new Node(8, 15.8);
    Node sixthNode = new Node(9.5, 11);
    Node seventhNode = new Node(8.9, 7.1);
    Node eighthNode = new Node(5.5, 6.5);
    Node ninthNode = new Node(6.2, 12.2);
    Node tenthNode = new Node(4.1, 14);

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
