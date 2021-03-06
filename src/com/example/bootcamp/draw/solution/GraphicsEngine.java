package com.example.bootcamp.draw.solution;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;

public class GraphicsEngine extends JFrame {

  private final CopyOnWriteArrayList<Drawable> drawables = new CopyOnWriteArrayList<>();
  
  public GraphicsEngine() {
    super("Graphics Engine");
    setVisible(true);
    setSize(640, 480);
    setExtendedState(JFrame.MAXIMIZED_BOTH );
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void setDrawables(Collection<? extends Drawable> drawables) {
    this.drawables.addAll(drawables);
  }

  public void paint(Graphics g) {
    Graphics2D graphics = (Graphics2D)g;
    Rectangle bounds = graphics.getClipBounds();
    graphics.setColor(Color.white);
    graphics.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);

    DrawingBoard drawingBoard = new Graphics2dDrawingBoard(graphics);

    for (Drawable drawable : drawables) {
      // Reset the drawing board
      drawingBoard.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      drawingBoard.setFill(Color.white);
      drawingBoard.setPenColor(Color.black);
      drawingBoard.setPenStroke(new BasicStroke(5));
      
      for (Decorator decorator : drawable.getDecorators()) {
        decorator.decorate(drawingBoard, drawable);
      }
      
      drawable.draw(drawingBoard);
    }
  }
}
