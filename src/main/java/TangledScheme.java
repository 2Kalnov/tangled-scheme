import core.entity.tangle.factory.FourCrossingsTangleFactory;
import core.entity.tangle.factory.TangleFactory;
import core.model.Model;
import view.GamePanel;
import view.field.FieldWidget;

public class TangledScheme {
  public static void main(String[] args) {
    TangleFactory factory = new FourCrossingsTangleFactory();
    Model model = new Model(factory);

    FieldWidget fieldWidget = new FieldWidget(model.getFieldWidth(), model.getFieldHeight());

    GamePanel mainWindow = new GamePanel(model, fieldWidget);
  }
}
