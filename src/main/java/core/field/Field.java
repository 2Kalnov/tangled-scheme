package core;

import core.entity.node.Node;
import core.entity.tangle.Tangle;
import core.field.geometry.Point;

import java.util.Set;

public class Field {
  private double width;
  private double height;

  private Tangle tangle;

  public void setTangle(Tangle tangle) {
    this.tangle = tangle;
  }

  public Tangle getTangle() {
    return tangle;
  }

  public boolean moveNode(Point supposedNodePosition, Point targetPosition) {
    // Поиск узла среди всех узлов в клубке

    // Проверяем, что узел хотят переместить в пределах поля
    if(supposedNodePosition.getX() <= )

    Set<Node> nodes = tangle.getNodes();
    boolean successfulMove = false;

    for(Node node : nodes) {
      Point nodePosition = node.getPosition();

      // TODO учитывать радиус вершины, поскольку на экране она отображается не точкой, а кругом
      if(nodePosition.equals(supposedNodePosition))
        node.move(
                targetPosition.getX() - supposedNodePosition.getX(),
                targetPosition.getY() - supposedNodePosition.getY()
        );

      successfulMove = true;
    }

    return successfulMove;
  }
}
