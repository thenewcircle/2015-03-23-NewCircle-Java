package com.example.bootcamp.draw.solution;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DrawableLine implements Drawable {

  private final Point pointA;
  private final Point pointB;

  private final LineDrawingStrategy strategy = new LineDrawingStrategy();
  private final List<Decorator> decorators = new ArrayList<>();
  
  public DrawableLine(Point pointA, Point pointB, Decorator...decorator) {
    this(pointA, pointB, Arrays.asList(decorator));
  }

  public DrawableLine(Point pointA, Point pointB, Collection<? extends Decorator> decorators) {
    this.decorators.addAll(decorators);

    this.pointA = pointA;
    this.pointB = pointB;
  }

  @Override
  public String getName() {
    return "Line";
  }

  @Override
  public Point getCenter() {
    int x = (pointA.x + pointB.x) / 2;
    int y = (pointA.y + pointB.y) / 2;
    return new Point(x, y);
  }
  
  @Override
  public void draw(DrawingBoard drawingBoard) {
    strategy.draw(drawingBoard, false, Arrays.asList(pointA, pointB));
  }

  @Override
  public Collection<Decorator> getDecorators() {
    return decorators;
  }
}
