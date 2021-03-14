package view.entity.node;

import core.entity.node.Node;
import core.field.geometry.Point;
import view.event.NodeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class NodeWidget extends JPanel {
  protected static int NODE_DIAMETER = 30;
  protected static int BORDER_SIZE = 6;
  protected final Node node;
  protected Color color;
  private List<NodeListener> listeners;

  public NodeWidget(final Node node) {
    this.node = node;
    initMouseListener();
    listeners = new ArrayList<>();
  }

  public NodeWidget(final Node node, Color color) {
    this(node);
    this.color = color;
    setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue(), 0));
  }

  public void addListener(NodeListener listener) {
    if(listener != null && !listeners.contains(listener))
      listeners.add(listener);
  }

  @Override
  public Dimension getSize() {
    int size = NODE_DIAMETER;
    return new Dimension(size, size);
  }

  public core.field.geometry.Point getPosition() {
    return this.node.getPosition();
  }

  private void notifyNodeMoved(Point targetPosition) {
    for(NodeListener listener : listeners)
      listener.nodeMoved(node, targetPosition);
  }

  private void notifyNodePlaced() {
    for(NodeListener listener : listeners)
      listener.nodePlaced();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics2D = (Graphics2D)g;
    graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Граница узла
    graphics2D.setColor(Color.BLACK);
    graphics2D.fillOval(0, 0, NODE_DIAMETER, NODE_DIAMETER);

    // Узел
    graphics2D.setColor(this.color);
    graphics2D.fillOval(
            BORDER_SIZE / 2,
            BORDER_SIZE / 2,
            NODE_DIAMETER - BORDER_SIZE,
            NODE_DIAMETER - BORDER_SIZE
    );
  }

  protected void initMouseListener() {
    this.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        core.field.geometry.Point targetPosition = new core.field.geometry.Point(
                node.getPosition().getX() + e.getX() - NODE_DIAMETER / 2,
                node.getPosition().getY() + e.getY() - NODE_DIAMETER / 2
        );

        System.out.println("Target position: " + targetPosition.toString());
        notifyNodeMoved(targetPosition);
      }
    });

    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        notifyNodePlaced();
      }
    });
  }

  @Override
  public int hashCode() {
    return this.node.hashCode();
  }
}