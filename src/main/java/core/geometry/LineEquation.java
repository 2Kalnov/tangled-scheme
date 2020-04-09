package core.geometry;

public class LineEquation {
  private double k;
  private double b;

  protected LineEquation(double k, double b) {
    this.k = k;
    this.b = b;
  }

  public double getK() {
    return this.k;
  }

  public double getB() {
    return this.b;
  }

  public static LineEquation getLineEquation(Line line) {
    Point left, right;
    left = line.getLeftPoint();
    right = line.getRightPoint();

    double leftX, leftY, rightX, rightY;

    leftX = left.getX();
    leftY = left.getY();

    rightX = right.getX();
    rightY = right.getY();

    double k = (leftY - rightY) / (leftX - rightX);
    double b = leftY - (rightY - leftY) / (rightX - leftX) * leftX;

    return new LineEquation(k, b);
  }
}
