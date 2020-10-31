package core.model;

import core.entity.tangle.factory.FourCrossingsTangleFactory;
import core.entity.tangle.factory.TangleFactory;
import org.junit.jupiter.api.Test;

public class ModelTests {
  @Test
  void untangle() {
    TangleFactory tangleFactory = new FourCrossingsTangleFactory();
    Model model = new Model(tangleFactory);

    model.start();

    // TODO смоделировать процесс игры
  }
}
