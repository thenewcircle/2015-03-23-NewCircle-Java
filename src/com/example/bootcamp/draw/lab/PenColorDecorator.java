package com.example.bootcamp.draw.lab;

import java.awt.Color;

public class PenColorDecorator implements Decorator {

  private final Color color;
  
  public PenColorDecorator(Color color) {
    super();
    this.color = color;
  }

  @Override
  public void decorate(DrawingBoard drawingBoard, Drawable drawable) {
    drawingBoard.setPenColor(color);
  }
}
