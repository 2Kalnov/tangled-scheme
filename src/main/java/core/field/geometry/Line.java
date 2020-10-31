package core.field.geometry;

import org.apache.commons.math3.linear.*;

import java.util.Objects;

public class Line {
  private Point start;
  private Point end;

  protected LineEquation equation;

  public Line(Point start, Point end) {
    if(!start.equals(end)) {
      this.start = start;
      this.end = end;

      this.equation = LineEquation.getLineEquation(this);
    } else
      throw new IncorrectLineException("Start point equals end point");
  }

  public Point getStartPoint() {
    return this.start;
  }

  public Point getEndPoint() {
    return this.end;
  }

  public double length() {
    return start.distanceTo(end);
  }

  public LineEquation getEquation() {
    return this.equation;
  }

  public Point getLeftPoint() {
    if(start.isToTheLeft(end))
      return start;
    else
      return end;
  }

  public Point getRightPoint() {
    if(start.isToTheRight(end))
      return start;
    else
      return end;
  }

  public boolean cross(Line otherLine) {
    LineEquation otherLineEquation = otherLine.equation;

    RealMatrix coefficients = new Array2DRowRealMatrix(new double[][] { { equation.getK(), -1 }, { otherLineEquation.getK(), -1 } });

    DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();

    RealVector constants = new ArrayRealVector(new double[] { -equation.getB(), -otherLineEquation.getB() });
    RealVector solution = solver.solve(constants);

    double crossingPointX = solution.getEntry(0);

    double lineLeftPointX, lineRightPointX, otherLineLeftPointX, otherLineRightPointX;
    lineLeftPointX = this.getLeftPoint().getX();
    lineRightPointX = this.getRightPoint().getX();
    otherLineLeftPointX = otherLine.getLeftPoint().getX();
    otherLineRightPointX = otherLine.getRightPoint().getX();

    boolean isCrossing =
            (crossingPointX >= lineLeftPointX && crossingPointX <= lineRightPointX) &&
            (crossingPointX >= otherLineLeftPointX && crossingPointX <= otherLineRightPointX);

    return isCrossing;
  }

  @Override
  public boolean equals(Object other) {
    boolean areEqual = false;

    if(other != null && other instanceof Line) {
      Line otherLine = (Line)other;

      if(otherLine.start.equals(start) && otherLine.end.equals(end) || otherLine.start.equals(end) && otherLine.end.equals(start))
        areEqual = true;
    }

    return areEqual;
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end);
  }
}
