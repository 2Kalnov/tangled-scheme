package view.entity.tangle;

import core.entity.tangle.factory.FourCrossingsTangleFactory;
import core.entity.tangle.factory.NineCrossingsTangleFactory;
import core.entity.tangle.factory.TangleFactory;

import java.util.HashMap;
import java.util.Map;

public class TanglePicker {
  public static String NINE_CROSSINGS_TANGLE = "nineCrossings";
  public static String FOUR_CROSSINGS_TANGLE = "fourCrossings";
  private Map<String, TangleFactory> factories;

  public TanglePicker() {
    this.factories = new HashMap<>();

    factories.put(FOUR_CROSSINGS_TANGLE, new FourCrossingsTangleFactory());
    factories.put(NINE_CROSSINGS_TANGLE, new NineCrossingsTangleFactory());
  }

  public TangleFactory chooseTangle(String tangleName) {
    return factories.get(tangleName);
  }
}
