package core.model;

import core.entity.node.Node;
import core.entity.tangle.factory.FourCrossingsTangleFactory;
import core.entity.tangle.factory.TangleFactory;
import core.field.Field;
import core.entity.tangle.Tangle;
import core.event.TangleStateListener;
import core.field.PositionOccupiedException;
import core.field.PositionOutOfFieldException;
import core.field.geometry.Point;
import lombok.Getter;

public class Model implements TangleStateListener {
  private static final double FIELD_WIDTH = 200;
  private static final double FIELD_HEIGHT = 200;

  private TangleFactory tangleFactory;

  public Model() {
    this.tangleFactory = new FourCrossingsTangleFactory();
  }

  public Model(TangleFactory factory) {
    this.tangleFactory = factory;
  }

  @Override
  public void tangleStateChanged() {
    Tangle tangle = gameField.getTangle();
    this.isTangled = tangle.getEdgesCrossingCount() > 0;
  }

  @Getter
  private boolean isTangled = true;
  private Field gameField;

  public void start() {
    Tangle tangle = this.tangleFactory.getTangle();
    this.gameField = new Field(tangleFactory.getWidth(), tangleFactory.getHeight());
    this.gameField.setTangle(tangle);

    tangle.addListener(this);
  }

  public int getFieldWidth() {
    return gameField.getWidth();
  }

  public int getFieldHeight() {
    return gameField.getHeight();
  }

  public Tangle getTangle() {
    return gameField.getTangle();
  }

  public void moveNode(Node nodeToMove, Point targetPosition) throws PositionOutOfFieldException, PositionOccupiedException {
    gameField.moveNode(nodeToMove, targetPosition);
  }
}
