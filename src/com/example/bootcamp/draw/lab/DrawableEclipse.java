package com.example.bootcamp.draw.lab;

import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
}
