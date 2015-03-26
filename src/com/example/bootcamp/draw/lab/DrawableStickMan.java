package com.example.bootcamp.draw.lab;

import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DrawableStickMan implements Drawable {

  private final LineDrawingStrategy lineStrategy = new LineDrawingStrategy();
  private final EclipseDrawingStrategy eclipseStrategy = new EclipseDrawingStrategy();

  private int x;
  private int y;
  
  private final List<Decorator> decorators = new ArrayList<>();
  
  public DrawableStickMan(int x, int y, Decorator...decorator) {
    this(x, y, Arrays.asList(decorator));
  }

  public DrawableStickMan(int x, int y, Collection<? extends Decorator> decorators) {
    this.decorators.addAll(decorators);
    this.x = x ;
    this.y = y;
  }

  @Override
  public String getName() {
    return "Stick Man";
  }

  @Override
  public Point getCenter() {
    return new Point(x+10, y+125);
  }
  
  public void setX(int x) {
    this.x = x;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  
  public void setXY(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  @Override
  public void draw(DrawingBoard drawingBoard) {

    eclipseStrategy.draw(drawingBoard, x, y, 50, 50);

    List<Point> points = Arrays.asList(
        new Point(x,y+25),
        new Point(x,y+55),
        new Point(x-20, y+100),
        new Point(x,y+55),
        new Point(x+20, y+100),
        new Point(x,y+55),
        new Point(x,y+150),
        new Point(x-20, y+300),
        new Point(x,y+150),
        new Point(x+20, y+300)
        );
    
    lineStrategy.draw(drawingBoard, false, points);
  }

  @Override
  public Collection<Decorator> getDecorators() {
    return decorators;
  }
}
