package view;

import core.event.GameStateListener;
import core.model.Model;
import view.entity.tangle.TangleWidget;
import view.entity.tangle.TangleWidgetFactory;
import view.field.FieldWidget;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame implements GameStateListener {

  private final Model model;
  private final FieldWidget fieldWidget;

  public GamePanel(Model model, FieldWidget field) {
    this.model = model;
    this.fieldWidget = field;

    fieldWidget.setTangle(TangleWidgetFactory.getTangle(model.getTangle()));
    model.addListener(this);

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

  @Override
  public void tangleUpdated(boolean isTangled) {
    fieldWidget.repaint();
    final String MESSAGE_TITLE = "Игра окончена";

    // Пользователь распутал клубок
    if(!isTangled)
      JOptionPane.showMessageDialog(this, "Поздравляем! Вы распутали этот клубок :)", MESSAGE_TITLE, JOptionPane.PLAIN_MESSAGE);
  }
}
