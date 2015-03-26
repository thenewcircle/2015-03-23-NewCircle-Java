package com.example.bootcamp.draw.solution;

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
  
  private String text;
  private int textX;
  private int textY;
  private Color textColor;

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
    
    if (text != null) {
      graphics.setColor(textColor);
      graphics.drawString(text, textX, textY);
    }
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

  @Override
  public void setText(String text, Color textColor, int x, int y) {
    this.text = text;
    this.textColor = textColor;
    this.textX = x;
    this.textY = y;
  }
}

