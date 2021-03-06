import core.entity.tangle.factory.FourCrossingsTangleFactory;
import core.entity.tangle.factory.NineCrossingsTangleFactory;
import core.entity.tangle.factory.TangleFactory;
import core.model.Model;
import view.ui.GamePanel;
import view.field.FieldWidget;

import javax.swing.*;

public class TangledScheme {
  public static void main(String[] args) {
    TangleFactory factory = new NineCrossingsTangleFactory();
    Model model = new Model(factory);
    model.start();
    
    FieldWidget fieldWidget = new FieldWidget(model.getFieldWidth(), model.getFieldHeight());

    SwingUtilities.invokeLater(() -> new GamePanel(model, fieldWidget));
  }
}
