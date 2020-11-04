package core.model;

import core.entity.node.Node;
import core.entity.tangle.factory.FourCrossingsTangleFactory;
import core.entity.tangle.factory.TangleFactory;
import core.event.GameStateListener;
import core.field.Field;
import core.entity.tangle.Tangle;
import core.event.TangleStateListener;
import core.field.PositionOccupiedException;
import core.field.PositionOutOfFieldException;
import core.field.geometry.Point;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Model implements TangleStateListener {

  private List<GameStateListener> listeners;
  private TangleFactory tangleFactory;
  private Field gameField;

  public Model() {
    this.tangleFactory = new FourCrossingsTangleFactory();
  }

  public Model(TangleFactory factory) {
    this.tangleFactory = factory;
  }

  @Override
  public void tangleStateChanged() {
    boolean isTangled = gameField.getTangle().getEdgesCrossingCount() > 0;

    for(GameStateListener listener : listeners)
      listener.tangleUpdated(isTangled);
  }

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

  public boolean isTangled() {
    return getTangle().getEdgesCrossingCount() == 0;
  }

  public void moveNode(Node nodeToMove, Point targetPosition) throws PositionOutOfFieldException, PositionOccupiedException {
    gameField.moveNode(nodeToMove, targetPosition);
  }

  public void addListener(GameStateListener listener) {
    if(listeners == null)
      listeners = new ArrayList<>();
    if(listener != null && !listeners.contains(listener))
      listeners.add(listener);
  }
}
