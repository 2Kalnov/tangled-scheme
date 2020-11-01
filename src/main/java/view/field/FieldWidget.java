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
    setPreferredSize(new Dimension(width, height));
    setLayout(null);
  }

  public void setTangle(TangleWidget tangleWidget) {
    this.tangle = tangleWidget;

    // Добавляем узлы на поле
    for(NodeWidget node : tangleWidget.getNodes())
      this.add(node);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D)g;

    // Задание границ узлов
    for(NodeWidget node : tangle.getNodes()) {
      int nodeSize = node.getSize().width;

      core.field.geometry.Point nodePosition = node.getPosition();
      int x = nodePosition.getX();
      int y = nodePosition.getY();
      node.setBounds(x - nodeSize / 2, y - nodeSize / 2, nodeSize, nodeSize);
    }

    // Отрисовка рёбер, которые не кликабельны и могут не добавляться в контейнер (поле) отдельно
    for(EdgeWidget edge : tangle.getEdges()) {
      // Рёбра отрисовываются на том же холсте; рёбра не являются виджетами!
      edge.paint(g2d);
    }
  }
}
