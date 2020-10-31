package view.entity.node;

import core.entity.node.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class NodeWidget extends JPanel {
  protected static int NODE_DIAMETER = 5;

  protected final Node node;
  protected Color color;

  public NodeWidget(final Node node) {
    this.node = node;
  }

  public NodeWidget(final Node node, Color color) {
    this.node = node;
    this.color = color;
  }

  public int getDiameter() {
    return NODE_DIAMETER;
  }

  public core.field.geometry.Point getPosition() {
    return this.node.getPosition();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics2D = (Graphics2D)g;

    double x = this.node.getPosition().getX();
    double y = this.node.getPosition().getY();

    Shape node = new Ellipse2D.Double(x, y, NODE_DIAMETER, NODE_DIAMETER);
    graphics2D.fill(node);
  }

  @Override
  public int hashCode() {
    return this.node.hashCode();
  }


}
