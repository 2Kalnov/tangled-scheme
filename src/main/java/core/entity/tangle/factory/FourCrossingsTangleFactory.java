package core.entity.tangle.factory;

import core.entity.edge.Edge;
import core.entity.node.Node;
import core.entity.tangle.Tangle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FourCrossingsTangleFactory implements TangleFactory {
  private final static int TANGLE_WIDTH = 350;
  private final static int TANGLE_HEIGHT = 450;

  @Override
  public Tangle getTangle() {
    // Создание узлов
    Set<Node> startingTangleNodes = new HashSet<>();
    Node left = new Node(20, 60);
    Node topLeft = new Node(40, 100);
    Node topRight = new Node(70, 100);
    Node right = new Node(90, 60);
    Node bottomRight = new Node(70, 20);
    Node bottomLeft = new Node(40, 20);

    startingTangleNodes.addAll(Arrays.asList(left, topLeft, topRight, right, bottomRight, bottomLeft));

    // Создание рёбер
    Set<Edge> startingTangleEdges = new HashSet<>();
    Edge leftTopLeft = new Edge(left, topLeft);
    Edge leftTopRight = new Edge(left, topRight);
    Edge leftBottomRight = new Edge(left, bottomRight);
    Edge topLeftRight = new Edge(topLeft, right);
    Edge topLeftTopRight = new Edge(topLeft, topRight);
    Edge topLeftBottomLeft = new Edge(topLeft, bottomLeft);
    Edge rightBottomLeft = new Edge(right, bottomLeft);
    Edge bottomRightBottomLeft = new Edge(bottomRight, bottomLeft);

    startingTangleEdges.addAll(Arrays.asList(
            leftTopLeft, leftTopRight, leftBottomRight, topLeftRight, topLeftTopRight, topLeftBottomLeft, rightBottomLeft, bottomRightBottomLeft
    ));

    return new Tangle(startingTangleNodes, startingTangleEdges);
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
