package view.field;

import view.entity.edge.EdgeWidget;
import view.entity.node.NodeWidget;
import view.entity.tangle.TangleWidget;

import javax.swing.*;
import java.awt.*;

public class FieldWidget extends JPanel {
  protected TangleWidget tangle;

  private final int height;
  private final int width;

  public FieldWidget(int width, int height) {
    this.width = width;
    this.height = height;

    // null в качестве layout-manager позволяет задавать абсолютные координаты для вложенных виджетов
    this.setPreferredSize(new Dimension(width, height));
    this.setLayout(null);
  }

  public void setTangle(TangleWidget tangleWidget) {
    this.tangle = tangleWidget;

    // Добавляем узлы на поле
    for(NodeWidget node : tangleWidget.getNodes()) {
      this.add(node);
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D)g;

    // Отрисовка рёбер, которые не кликабельны и могут не добавляться в контейнер (поле) отдельно
    for(EdgeWidget edge : tangle.getEdges()) {
      // Рёбра отрисовываются на том же холсте; рёбра не являются виджетами!
      edge.paint(g2d);
    }

    for(NodeWidget node : tangle.getNodes()) {
      core.field.geometry.Point nodePosition = node.getPosition();
      int x = new Double(nodePosition.getX()).intValue();
      int y = new Double(nodePosition.getY()).intValue();
      node.setBounds(x, y, node.getDiameter(), node.getDiameter());
      node.repaint();
    }
  }
}
