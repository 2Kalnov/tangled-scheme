package core.field.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTests {
  @Test
  void notCrossingLines() {
    Line line = new Line(new Point(2, 6), new Point(7, 2));
    Line otherLine = new Line(new Point(1, 10), new Point(1, 2));

    Assertions.assertTrue(!line.cross(otherLine));
  }

  @Test
  void crossingLines() {
    Line line = new Line(new Point(1, 1), new Point(4, 8));
    Line otherLine = new Line(new Point(3, 1), new Point(1, 6));

    Assertions.assertTrue(line.cross(otherLine));
  }
}
