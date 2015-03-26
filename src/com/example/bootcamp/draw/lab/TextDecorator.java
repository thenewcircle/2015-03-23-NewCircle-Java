package com.example.bootcamp.draw.lab;

import java.awt.Color;

public class TextDecorator implements Decorator {

  private final Color color;
  private final String text;
  private final int x;
  private final int y;
  
  public TextDecorator(String text, Color color, int x, int y) {
    this.x = x;
    this.y = y;
    this.text = text;
    this.color = color;
  }

  @Override
  public void decorate(DrawingBoard drawingBoard, Drawable drawable) {
    drawingBoard.setText(text, color, x, y);
  }
}
