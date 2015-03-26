package com.example.bootcamp.draw.lab.decorator;

import java.awt.Color;

import com.example.bootcamp.draw.lab.DrawingBoard;
import com.example.bootcamp.draw.lab.drawable.Drawable;

/*pacakge*/ class PenColorDecorator implements Decorator {

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
