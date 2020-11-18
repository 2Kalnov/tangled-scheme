package core.entity.node;

import core.entity.node.moves.HorizontalMoveStrategy;
import core.entity.node.moves.MoveStrategy;
import core.entity.node.moves.NoMoveStrategy;
import core.field.geometry.Point;

import java.util.Random;

public class RandomNode extends Node {
  private static int THRESHOLD = 5;
  private static int UPPER_RANDOM_BOUND = THRESHOLD * 2;
  private MoveStrategy moveStrategy;

  public RandomNode(int x, int y) {
    super(x, y);

    int randomNumber = new Random().nextInt(UPPER_RANDOM_BOUND);
    System.out.println(randomNumber);
    if(randomNumber < THRESHOLD)
      moveStrategy = new HorizontalMoveStrategy();
    else
      moveStrategy = new NoMoveStrategy();
  }

  @Override
  protected boolean moveTo(int targetX, int targetY) {
    Point targetPosition = new Point(targetX, targetY);
    Point newPosition = moveStrategy.moveTo(this.position, targetPosition);

    boolean moved = !newPosition.equals(this.position);
    this.position = newPosition;

    return moved;
  }
}