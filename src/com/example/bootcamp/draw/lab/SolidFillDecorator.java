package com.example.bootcamp.draw.lab;

import java.awt.Color;
import java.awt.Paint;

public class SolidFillDecorator implements Decorator {

  private final Paint paint;
  
  public SolidFillDecorator(Paint paint) {
    this.paint = paint;
  }

  @Override
  public void decorate(DrawingBoard drawingBoard, Drawable drawable) {
    drawingBoard.setFill(paint);
  }
}
