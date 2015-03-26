package com.example.bootcamp.draw.solution;

import java.awt.BasicStroke;
import java.awt.Color;

public class PenSizeDecorator implements Decorator {

  private final int size;
  
  public PenSizeDecorator(int size) {
    this.size = size;
  }

  @Override
  public void decorate(DrawingBoard drawingBoard, Drawable drawable) {
    drawingBoard.setPenStroke(new BasicStroke(size));
  }
}
