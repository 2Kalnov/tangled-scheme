package core.field.geometry;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GeneralLineEquation {

  /* Коэффициент при x */
  private double a;

  /* Коэффициент при y */
  private double b;

  /* Свободный член */
  private double c;

  public static GeneralLineEquation getGeneralLineEquation(Line line) {
    Point start = line.getStartPoint();
    Point end = line.getEndPoint();

    double a = start.getY() - end.getY();
    double b = end.getX() - start.getX();
    double c = start.getX() * end.getY() - end.getX() * start.getY();

    return new GeneralLineEquation(a, b, c);
  }
}
