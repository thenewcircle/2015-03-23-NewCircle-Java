package com.example.bootcamp.draw.lab.decorator;

import java.awt.Color;
import java.awt.Point;

import com.example.bootcamp.draw.lab.DrawingBoard;
import com.example.bootcamp.draw.lab.drawable.Drawable;

class PrintNameDecorator implements Decorator {

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
