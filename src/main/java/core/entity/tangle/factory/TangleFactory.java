package core.entity.tangle.factory;

import core.entity.tangle.Tangle;

public interface TangleFactory {
  Tangle getTangle();
  int getWidth();
  int getHeight();
}
