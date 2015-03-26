package com.example.bootcamp.draw.lab;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;

public interface DrawingBoard {

  void drawShape(Shape shape);

  void setPenColor(Color rgb);
  void setPenStroke(Stroke stroke);
  void setFill(Paint paint);
  void setRenderingHint(Key hintKey, Object hintValue);
  void setText(String text, Color textColor, int x, int y);
}
