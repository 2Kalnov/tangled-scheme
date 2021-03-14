package view.field;

import view.entity.edge.EdgeWidget;
import view.entity.node.NodeWidget;
import view.entity.tangle.TangleWidget;

import javax.swing.*;
import java.awt.*;

public class FieldWidget extends JPanel {
  protected TangleWidget tangle;
  private final int width;
  private final int height;

  public FieldWidget(int width, int height) {
    // null в качестве layout-manager позволяет задавать абсолютные координаты для вложенных виджетов
    setPreferredSize(new Dimension(width, height));

    this.width = width;
    this.height = height;
  }

  public void setTangle(TangleWidget tangleWidget) {
    this.tangle = tangleWidget;

    add(tangleWidget);
    tangleWidget.setPreferredSize(new Dimension(width, height));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    System.out.println("Repainting field");
  }
}
