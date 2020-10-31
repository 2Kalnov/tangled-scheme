package view;

import core.model.Model;
import view.field.FieldWidget;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame {

  private final Model model;
  private final FieldWidget field;

  public GamePanel(Model model, FieldWidget field) {
    this.model = model;
    this.field = field;

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Запутанная схема");

    // Фиксированные размеры главного окна
    setResizable(false);
    setLocationRelativeTo(null);

    JPanel contentPanel = (JPanel)this.getContentPane();
    contentPanel.add(field, BorderLayout.CENTER);
    pack();
    setVisible(true);
  }

  private void configureWindow() {

  }

  private void subscribeToMouseEvents() {

  }
}
