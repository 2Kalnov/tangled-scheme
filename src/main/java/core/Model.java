package core;

import core.event.TangleStateListener;

public class Model implements TangleStateListener {
  @Override
  public void update(boolean isTangled) {

  }

  protected boolean isTangled;
  protected Field gameField;

  public void start() {

  }

  protected boolean checkTangleValidity() {
    return false;
  }
}
