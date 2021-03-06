package com.example.bootcamp.draw.lab.drawable;

import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.example.bootcamp.draw.lab.DrawingBoard;
import com.example.bootcamp.draw.lab.LineDrawingStrategy;
import com.example.bootcamp.draw.lab.decorator.Decorator;

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
//
//    GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 2);
//
//    polygon.moveTo(pointA.getX(), pointA.getY());
//    polygon.lineTo(pointB.getX(), pointB.getY());
//
//    // polygon.closePath();
//
//    drawingBoard.drawShape(polygon);  
  }

  @Override
  public Collection<Decorator> getDecorators() {
    return decorators;
  }

  @Override
  public int compareTo(Drawable that) {
    return this.getShapeType().compareTo(that.getShapeType());
  }

  @Override
  public ShapeType getShapeType() {
    return ShapeType.Line;
  }
}
