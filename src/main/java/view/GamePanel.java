package view;

import core.model.Model;
import view.entity.tangle.TangleWidget;
import view.entity.tangle.TangleWidgetFactory;
import view.field.FieldWidget;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame {

  private final Model model;
  private final FieldWidget fieldWidget;

  public GamePanel(Model model, FieldWidget field) {
    this.model = model;
    this.fieldWidget = field;

    fieldWidget.setTangle(TangleWidgetFactory.getTangle(model.getTangle()));

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

  private void configureWindow() {

  }

  private void subscribeToMouseEvents() {

  }
}
