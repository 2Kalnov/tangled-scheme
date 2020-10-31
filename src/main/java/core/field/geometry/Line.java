package core.field.geometry;

import lombok.Getter;
import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.util.Precision;

import java.util.Objects;

public class Line {
  private Point start;
  private Point end;

  @Getter
  protected GeneralLineEquation equation;

  public Line(Point start, Point end) {
    if(!start.equals(end)) {
      this.start = start;
      this.end = end;

      this.equation = GeneralLineEquation.getGeneralLineEquation(this);
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

  public Point getTopPoint() {
    if(start.isUpper(end))
      return start;
    else
      return end;
  }

  public Point getBottomPoint() {
    if(start.isBelow(end))
      return start;
    else
      return end;
  }

  public boolean cross(Line otherLine) {
    boolean isCrossing;

    GeneralLineEquation otherLineEquation = otherLine.equation;

    RealMatrix coefficients = new Array2DRowRealMatrix(new double[][] { { equation.getA(), equation.getB() }, { otherLineEquation.getA(), otherLineEquation.getB() } });
    DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
    RealVector constants = new ArrayRealVector(new double[] { -equation.getC(), -otherLineEquation.getC() });

    try {
      RealVector solution = solver.solve(constants);

      double crossingPointX = Precision.round(solution.getEntry(0), 6);
      double crossingPointY = Precision.round(solution.getEntry(1), 6);

      //Point crossingPoint = new Point(crossingPointX, crossingPointY);

      int lineLeftPointX, lineRightPointX, otherLineLeftPointX, otherLineRightPointX;
      lineLeftPointX = this.getLeftPoint().getX();
      lineRightPointX = this.getRightPoint().getX();
      otherLineLeftPointX = otherLine.getLeftPoint().getX();
      otherLineRightPointX = otherLine.getRightPoint().getX();

      int lineTopPointY, lineBottomPointY, otherLineTopPointY, otherLineBottomPointY;
      lineTopPointY = this.getTopPoint().getY();
      lineBottomPointY = this.getBottomPoint().getY();
      otherLineTopPointY = otherLine.getTopPoint().getY();
      otherLineBottomPointY = otherLine.getBottomPoint().getY();

      isCrossing =
              (crossingPointX >= lineLeftPointX && crossingPointX <= lineRightPointX) &&
              (crossingPointX >= otherLineLeftPointX && crossingPointX <= otherLineRightPointX) &&
              (crossingPointY >= lineBottomPointY && crossingPointY <= lineTopPointY) &&
              (crossingPointY >= otherLineBottomPointY && crossingPointY <= otherLineTopPointY) &&
              //(!crossingPoint.equals(getStartPoint()) && !crossingPoint.equals(getEndPoint())) &&
              !(crossingPointX == getStartPoint().getX() && crossingPointY == getStartPoint().getY()) &&
              !(crossingPointX == getEndPoint().getX() && crossingPointY == getEndPoint().getY()) &&
              //(!crossingPoint.equals(otherLine.getStartPoint()) && !crossingPoint.equals(otherLine.getEndPoint()));
              !(crossingPointX == otherLine.getStartPoint().getX() && crossingPointX == otherLine.getStartPoint().getY()) &&
              !(crossingPointX == otherLine.getEndPoint().getX() && crossingPointY == otherLine.getEndPoint().getY());

    } catch(SingularMatrixException exception) { // Решения системы уравнений прямых, на которых лежат отрезки, нет
      isCrossing = false;
    }

    StringBuilder crossingInfoBuilder = new StringBuilder();
    crossingInfoBuilder.append(this.toString());
    crossingInfoBuilder.append("\n");
    crossingInfoBuilder.append(otherLine.toString());
    crossingInfoBuilder.append("\n");
    crossingInfoBuilder.append("Crossing: ");
    crossingInfoBuilder.append(isCrossing);
    crossingInfoBuilder.append("\n");

    System.out.println(crossingInfoBuilder.toString());

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

  @Override
  public String toString() {
    StringBuilder edgeDescriptionBuilder = new StringBuilder();

    edgeDescriptionBuilder.append("Start: ");
    edgeDescriptionBuilder.append(this.start.toString());
    edgeDescriptionBuilder.append(", end: ");
    edgeDescriptionBuilder.append(this.end.toString());

    return edgeDescriptionBuilder.toString();
  }
}
