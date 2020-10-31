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

  private boolean isTangled;
  private Field gameField;
  private String startTangleFilePath;

  public void start() {
    // Загрузка клубка из файла

    File 
  }

  public void setStartTangleFilePath(String filePath) {
    this.startTangleFilePath = filePath;
  }

  protected boolean checkTangleValidity() {
    return false;
  }
}
