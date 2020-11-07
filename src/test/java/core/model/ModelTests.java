package core.model;

import core.entity.node.Node;
import core.entity.tangle.factory.FourCrossingsTangleFactory;
import core.entity.tangle.factory.TangleFactory;
import core.event.GameStateListener;
import core.field.PositionOccupiedException;
import core.field.PositionOutOfFieldException;
import core.field.geometry.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ModelTests {

  private static class Player implements GameStateListener {
    private boolean isTangled;

    @Override
    public void tangleUpdated(boolean isTangled) {
      this.isTangled = isTangled;
    }

    public boolean isGameOver() {
      return !isTangled;
    }
  }

  @Test
  void untangle() throws PositionOutOfFieldException, PositionOccupiedException {
    TangleFactory tangleFactory = new FourCrossingsTangleFactory();
    Model model = new Model(tangleFactory);

    Player player = new Player();

    model.start();
    model.addListener(player);

    Set<Node> nodes = model.getTangle().getNodes();
    Node bottomRight = findNode(nodes, new Point(280, 80));
    Node topRight = findNode(nodes, new Point(280, 400));

    // Первый шаг
    model.moveNode(topRight, new Point(100, 80));

    // Второй шаг
    model.moveNode(bottomRight, new Point(130, 240));

    Assertions.assertTrue(player.isGameOver());

    // TODO смоделировать процесс игры
  }

  private Node findNode(Set<Node> tangleNodes, Point nodePosition) {
    return tangleNodes.stream().filter(node -> node.getPosition().equals(nodePosition)).findFirst().get();
  }
}
