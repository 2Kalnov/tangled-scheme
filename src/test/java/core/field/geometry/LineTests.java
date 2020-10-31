package core.field.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTests {
  @Test
  void notCrossingLines() {
    Line line = new Line(new Point(2, 6), new Point(7, 2));
    Line otherLine = new Line(new Point(4, 10), new Point(4, 2));

    Assertions.assertTrue(line.cross(otherLine));
  }
}
