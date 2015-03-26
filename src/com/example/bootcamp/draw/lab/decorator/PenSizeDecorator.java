package com.example.bootcamp.draw.lab.decorator;

import java.awt.BasicStroke;

import com.example.bootcamp.draw.lab.DrawingBoard;
import com.example.bootcamp.draw.lab.drawable.Drawable;

/*package*/ class PenSizeDecorator implements Decorator {

  private final int size;
  
  public PenSizeDecorator(int size) {
    this.size = size;
  }

  @Override
  public void decorate(DrawingBoard drawingBoard, Drawable drawable) {
    drawingBoard.setPenStroke(new BasicStroke(size));
  }
}
