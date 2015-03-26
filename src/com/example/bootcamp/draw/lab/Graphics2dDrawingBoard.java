package com.example.bootcamp.draw.lab;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints.Key;
import java.awt.Shape;
import java.awt.Stroke;

public class Graphics2dDrawingBoard implements DrawingBoard {

  private Paint fill;
  private Color penColor;
  private Stroke stroke;
  
  private Key hintKey;
  private Object hintValue;
  
  private final Graphics2D graphics;
  
  public Graphics2dDrawingBoard(Graphics2D graphics) {
    this.graphics = graphics;
  }

  @Override
  public void drawShape(Shape shape) {
    graphics.setRenderingHint(hintKey, hintValue);
    graphics.setStroke(stroke);

    graphics.setPaint(fill);
    graphics.fill(shape);
    
    graphics.setColor(penColor);
    graphics.draw(shape);
  }

  @Override
  public void setPenColor(Color penColor) {
    this.penColor = penColor;
  }

  @Override
  public void setFill(Paint fill) {
    this.fill = fill;
  }

  @Override
  public void setPenStroke(Stroke stroke) {
    this.stroke = stroke;
  }

  @Override
  public void setRenderingHint(Key hintKey, Object hintValue) {
    this.hintKey = hintKey;
    this.hintValue = hintValue;
  }
}

