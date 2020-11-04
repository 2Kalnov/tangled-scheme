package core.entity.node;

public class VerticalNode extends Node {
  public VerticalNode(int x, int y) {
    super(x, y);
  }

  @Override
  protected boolean moveTo(int targetX, int targetY) {
    int yOffset = targetY - this.position.getY();
    this.position = this.position.move(0, yOffset);

    return yOffset != 0;
  }
}
