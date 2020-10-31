package core;

import core.event.TangleStateListener;

public class Model implements TangleStateListener {
  @Override
  public void update(boolean isTangled) {
    this.isTangled = isTangled;
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
