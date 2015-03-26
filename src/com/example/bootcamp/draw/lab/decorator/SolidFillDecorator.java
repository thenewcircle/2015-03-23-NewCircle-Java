package com.example.bootcamp.draw.lab.decorator;

import java.awt.Paint;

import com.example.bootcamp.draw.lab.DrawingBoard;
import com.example.bootcamp.draw.lab.drawable.Drawable;

class SolidFillDecorator implements Decorator {

  private final Paint paint;
  
  public SolidFillDecorator(Paint paint) {
    this.paint = paint;
  }

  @Override
  public void decorate(DrawingBoard drawingBoard, Drawable drawable) {
    drawingBoard.setFill(paint);
  }
}
