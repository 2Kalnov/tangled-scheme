package view.entity.edge;

import core.entity.edge.Edge;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class EdgeWidget {
  protected Color color = Color.BLACK;
  protected final Edge edge;

  public EdgeWidget(final Edge edge) {
    this.edge = edge;
  }

  public EdgeWidget(final Edge edge, Color color) {
    this.edge = edge;
    this.color = color;
  }

  /**
   * Отрисовка ребра на заданном "холсте"
   * @param g - объект Graphics, с помощью которого будет отрисовано ребро (обязательно требуется Graphics2D!)
   */
  public void paint(Graphics2D g) {
    core.field.geometry.Point start = this.edge.getLine().getStartPoint();
    core.field.geometry.Point end = this.edge.getLine().getEndPoint();

    // Shape line = new Line2D.Double(start.getX(), start.getY(), end.getX(), end.getY());
    // g.fill(line);
    g.setColor(Color.GRAY);
    g.setStroke(new BasicStroke(2));
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());

  }

  @Override
  public int hashCode() {
    return this.edge.hashCode();
  }
}
