package core.geometry;

public class Point {
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  private double x;
  private double y;

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public Point move(double xOffset, double yOffset) {
    double pointX = this.x;
    double pointY = this.y;
    return new Point(pointX + xOffset, pointY + yOffset);
  }

  public boolean isToTheLeft(Point otherPoint) {
    boolean isToTheLeft = false;
    if(this.x < otherPoint.x)
      isToTheLeft = true;

    return isToTheLeft;
  }

  public boolean isToTheRight(Point otherPoint) {
    return !this.isToTheLeft(otherPoint);
  }

  public boolean isUpper(Point otherPoint) {
    boolean isUpper = false;
    if(this.y > otherPoint.y)
      isUpper = true;

    return isUpper;
  }

  public boolean isBelow(Point otherPoint) {
    return !this.isUpper(otherPoint);
  }

  public double distanceTo(Point otherPoint) {
    double a, b; // Катеты прямоугольного треугольника

    double distance;

    a = this.x - otherPoint.x;
    b = this.y - otherPoint.y;

    distance = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

    return distance;
  }

  @Override
  public boolean equals(Object other) {
    if(other == null)
      return false;

    if(!(other instanceof Point))
      return false;

    Point otherPoint = (Point)other;

    if(this.x == otherPoint.x && this.y  == otherPoint.y)
      return true;
    else
      return false;
  }

  @Override
  public int hashCode() {
    return 397 * Double.hashCode(x) + Double.hashCode(y);
  }
}
