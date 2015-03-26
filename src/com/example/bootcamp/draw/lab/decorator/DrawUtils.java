package com.example.bootcamp.draw.lab.decorator;

import java.awt.Color;
import java.awt.Paint;

public abstract class DrawUtils {

  public static Decorator pen(int penSize) {
    return new PenSizeDecorator(penSize);
  }

  public static Decorator pen(Color color) {
    return new PenColorDecorator(color);
  }

  public static Decorator pen(Color color, int size) {
    return new PenDecorator(color, size);
  }

  public static Decorator fill(Color color) {
    return new SolidFillDecorator(color);
  }

  public static Decorator fill(Paint paint) {
    return new SolidFillDecorator(paint);
  }

  public static PrintNameDecorator name(Color color) {
    return new PrintNameDecorator(color);
  }
}
