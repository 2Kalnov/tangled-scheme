package view;

import core.entity.node.Node;
import core.event.GameStateListener;
import core.field.PositionOccupiedException;
import core.field.PositionOutOfFieldException;
import core.field.geometry.Point;
import core.model.Model;
import view.entity.node.NodeWidget;
import view.entity.tangle.TangleWidget;
import view.entity.tangle.TangleWidgetFactory;
import view.event.NodeListener;
import view.field.FieldWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GamePanel extends JFrame implements GameStateListener, NodeListener {

  private final Model model;
  private final FieldWidget fieldWidget;
  boolean isTangled;

  private final String MESSAGE_TITLE = "Игра окончена";
  private final String SUCCESSFUL_END_MESSAGE = "Поздравляем! Вы распутали этот клубок :)";

  public GamePanel(Model model, FieldWidget field) {
    this.model = model;
    this.fieldWidget = field;

    TangleWidget tangleWidget = TangleWidgetFactory.getTangle(model.getTangle());
    fieldWidget.setTangle(tangleWidget);

    model.addListener(this);
    subscribeOnNodes(tangleWidget);

    // Фиксированные размеры главного окна
    setResizable(false);
    setLocationRelativeTo(null);

    JPanel contentPanel = (JPanel)this.getContentPane();
    contentPanel.add(field, BorderLayout.CENTER);
    pack();
    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Запутанная схема");
  }

  private void subscribeOnNodes(TangleWidget tangle) {
    for(NodeWidget node : tangle.getNodes())
      node.addListener(this);
  }

  @Override
  public void tangleUpdated(boolean isTangled) {
    this.isTangled = isTangled;
    fieldWidget.repaint();
  }
}
