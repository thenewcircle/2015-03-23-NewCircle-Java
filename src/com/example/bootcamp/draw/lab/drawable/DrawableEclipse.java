package com.example.bootcamp.draw.lab.drawable;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.example.bootcamp.draw.lab.DrawingBoard;
import com.example.bootcamp.draw.lab.EclipseDrawingStrategy;
import com.example.bootcamp.draw.lab.decorator.Decorator;

public class DrawableEclipse implements Drawable {

  private int x; 
  private int y; 
  private int width;
  private int height;
  
  private final List<Decorator> decorators = new ArrayList<>();
  private final EclipseDrawingStrategy eclipseStrategy = new EclipseDrawingStrategy();
  
  public DrawableEclipse(int centerX, int centerY, int width, int height, 
                         Decorator...decorator) {
    this(centerX, centerY, width, height, Arrays.asList(decorator));
  }

  public DrawableEclipse(int centerX, int centerY, int width, int height, 
                         Collection<? extends Decorator> decorators) {
    this.x = centerX - (width/2);
    this.y = centerY - (height/2);
    this.width = width;
    this.height = height;
    this.decorators.addAll(decorators);
  }
  
  @Override
  public String getName() {
    return "Eclipse";
  }
  
  @Override
  public Point getCenter() {
    return new Point(x, y);
  }
  
  @Override
  public void draw(DrawingBoard drawingBoard) {
    eclipseStrategy.draw(drawingBoard, x, y, width, height);
  }

  @Override
  public Collection<Decorator> getDecorators() {
    return decorators;
  }

  @Override
  public String toString() {
    return "DrawableEclipse [x=" + x + ", y=" + y + ", width=" + width
        + ", height=" + height + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + height;
    result = prime * result + width;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DrawableEclipse other = (DrawableEclipse) obj;
    if (height != other.height)
      return false;
    if (width != other.width)
      return false;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

  @Override
  public int compareTo(Drawable that) {
    return this.getShapeType().compareTo(that.getShapeType());
  }

  @Override
  public ShapeType getShapeType() {
    return ShapeType.Eclipse;
  }
}
