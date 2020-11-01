package core.entity;

import core.entity.node.Node;
import core.entity.tangle.Tangle;
import core.entity.tangle.factory.FourCrossingsTangleFactory;
import core.entity.tangle.factory.NineCrossingsTangleFactory;
import core.entity.tangle.factory.TangleFactory;
import core.field.Field;
import core.field.NodeNotFoundException;
import core.field.PositionOccupiedException;
import core.field.PositionOutOfFieldException;
import core.field.geometry.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static core.field.Field.DEFAULT_FIELD_WIDTH;
import static core.field.Field.DEFAULT_FIELD_HEIGHT;


public class TangleTests {
  @Test
  void fourCrossingsStartingTangle() {
    Tangle tangle = new FourCrossingsTangleFactory().getTangle();

    Assertions.assertEquals(4, tangle.getEdgesCrossingCount());
  }

  @Test
  void nineCrossingStartingTangle() {
    Tangle tangle = new NineCrossingsTangleFactory().getTangle();

    Assertions.assertEquals(9, tangle.getEdgesCrossingCount());
  }

  @Test
  void moveNodeToRemoveOneCrossing() throws PositionOccupiedException, PositionOutOfFieldException, NodeNotFoundException {
    Field field = new Field(DEFAULT_FIELD_WIDTH, DEFAULT_FIELD_HEIGHT);

    TangleFactory tangleFactory = new FourCrossingsTangleFactory();
    Tangle tangle = tangleFactory.getTangle();
    field.setTangle(tangle);

    Node bottomRight = field.getNode(70, 20);
    if(bottomRight == null)
      throw new NodeNotFoundException();

    field.moveNode(bottomRight, new Point(60, 40));

    Assertions.assertEquals(3, tangle.getEdgesCrossingCount());
  }
}
