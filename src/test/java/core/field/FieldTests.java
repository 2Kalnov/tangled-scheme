package core.field;

import core.entity.node.Node;
import core.entity.tangle.Tangle;
import core.entity.tangle.factory.FourCrossingsTangleFactory;
import core.entity.tangle.factory.TangleFactory;
import core.field.geometry.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static core.field.Field.DEFAULT_FIELD_WIDTH;
import static core.field.Field.DEFAULT_FIELD_HEIGHT;

public class FieldTests {

  @Test
  void moveNodeToOccupiedPosition() {
    Field field = new Field(DEFAULT_FIELD_WIDTH, DEFAULT_FIELD_HEIGHT);

    TangleFactory tangleFactory = new FourCrossingsTangleFactory();
    Tangle tangle = tangleFactory.getTangle();
    field.setTangle(tangle);

    Node right = field.getNode(9, 6);

    Assertions.assertThrows(PositionOccupiedException.class, () -> {
      field.moveNode(right, new Point(2, 6));
    });
  }

  @Test
  void moveNodeOutOfField() {
    Field field = new Field(DEFAULT_FIELD_WIDTH, DEFAULT_FIELD_HEIGHT);

    TangleFactory tangleFactory = new FourCrossingsTangleFactory();
    Tangle tangle = tangleFactory.getTangle();
    field.setTangle(tangle);

    Node left = field.getNode(2, 6);

    Assertions.assertThrows(PositionOutOfFieldException.class, () -> {
      field.moveNode(left, new Point(-1, -1));
    });
  }
}
