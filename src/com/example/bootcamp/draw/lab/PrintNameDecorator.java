package com.example.bootcamp.draw.lab;

import java.awt.Color;
import java.awt.Point;

public class PrintNameDecorator implements Decorator {

  private final Color color;
  
  public PrintNameDecorator(Color color) {
    this.color = color;
  }

  @Override
  public void decorate(DrawingBoard drawingBoard, Drawable drawable) {
    Point center = drawable.getCenter();
    drawingBoard.setText(drawable.getName(), color, center.x, center.y);
  }
}
