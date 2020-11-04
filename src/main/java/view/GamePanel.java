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

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;

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
    this.isTangled = model.isTangled();

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
    setIcon();
  }

  private void subscribeOnNodes(TangleWidget tangle) {
    for(NodeWidget node : tangle.getNodes())
      node.addListener(this);
  }

  private void setIcon() {
    final String ICON_PATH = "tangle.png";
    try {
      Image image = ImageIO.read(getClass().getClassLoader().getResource(ICON_PATH));
      setIconImage(image);
    } catch (IOException e) {
      System.out.println("Невозможно загрузить иконку приложения!");
    }
  }

  @Override
  public void tangleUpdated(boolean isTangled) {
    this.isTangled = isTangled;
    fieldWidget.repaint();
  }

  @Override
  public void nodeMoved(Node node, Point targetPosition) {
    try {
      model.moveNode(node, targetPosition);
    } catch(PositionOccupiedException | PositionOutOfFieldException e) {
      showPlainMessage(e.getMessage(), "Ошибка");
    }
  }

  @Override
  public void nodePlaced() {
    // Пользователь распутал клубок
    if(!isTangled) {
      showPlainMessage(SUCCESSFUL_END_MESSAGE, MESSAGE_TITLE);
      dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
  }

  private void showPlainMessage(String message, String title) {
    JOptionPane.showMessageDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
  }
}