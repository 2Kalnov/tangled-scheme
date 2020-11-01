package view.entity.node;

import core.entity.node.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class NodeWidget extends JPanel {
  protected static int NODE_DIAMETER = 30;
  protected static int BORDER_SIZE = 8;

  protected final Node node;
  protected Color color;

  public NodeWidget(final Node node) {
    this.node = node;
  }

  public NodeWidget(final Node node, Color color) {
    this.node = node;
    this.color = color;
  }

  @Override
  public Dimension getSize() {
    int size = NODE_DIAMETER;
    return new Dimension(size, size);
  }

  public core.field.geometry.Point getPosition() {
    return this.node.getPosition();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics2D = (Graphics2D)g;
    graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int x = this.node.getPosition().getX();
    int y = this.node.getPosition().getY();

    // Граница узла
    graphics2D.setColor(Color.BLACK);
    graphics2D.fillOval(
            0, 0,
            NODE_DIAMETER,
            NODE_DIAMETER
    );

    // Узел
    graphics2D.setColor(this.color);
    graphics2D.fillOval(
            BORDER_SIZE / 2,
            BORDER_SIZE / 2,
            NODE_DIAMETER - BORDER_SIZE,
            NODE_DIAMETER - BORDER_SIZE
    );
  }

  @Override
  public int hashCode() {
    return this.node.hashCode();
  }


}
