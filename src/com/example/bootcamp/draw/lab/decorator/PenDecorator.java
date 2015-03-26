package com.example.bootcamp.draw.lab.decorator;

import java.awt.BasicStroke;
import java.awt.Color;

import com.example.bootcamp.draw.lab.DrawingBoard;
import com.example.bootcamp.draw.lab.drawable.Drawable;

class PenDecorator implements Decorator {

  private final int size;
  private final Color color;
  
  public PenDecorator(Color color, int size) {
    this.size = size;
    this.color = color;
  }

  @Override
  public void decorate(DrawingBoard drawingBoard, Drawable drawable) {
    drawingBoard.setPenColor(color);
    drawingBoard.setPenStroke(new BasicStroke(size));
  }
}
