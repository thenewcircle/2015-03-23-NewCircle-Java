package com.example.bootcamp.draw.lab.drawable;

import java.util.Arrays;
import java.util.Collection;

import com.example.bootcamp.draw.lab.decorator.Decorator;

public class DrawableSquare extends DrawableRectangle {

  public DrawableSquare(int centerX, int centerY, int width, 
                        Decorator...decorator) {
    
    this(centerX, centerY, width, Arrays.asList(decorator));
  }

  public DrawableSquare(int centerX, int centerY, int width, 
                        Collection<? extends Decorator> decorators) {
    
    super(centerX, centerY, width, width, decorators);
  }

  @Override
  public String getName() {
    return "Square";
  }

  @Override
  public int compareTo(Drawable that) {
    return this.getShapeType().compareTo(that.getShapeType());
  }

  @Override
  public ShapeType getShapeType() {
    return ShapeType.Square;
  }
}
