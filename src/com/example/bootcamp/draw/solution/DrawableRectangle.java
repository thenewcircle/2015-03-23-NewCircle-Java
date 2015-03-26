package com.example.bootcamp.draw.solution;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DrawableRectangle implements Drawable {

  private final Point center;
  private final List<Point> points = new ArrayList<>();
  private final LineDrawingStrategy strategy = new LineDrawingStrategy();
  private final List<Decorator> decorators = new ArrayList<>();
  
  public DrawableRectangle(int centerX, int centerY, int width, int height, Decorator...decorator) {
    this(centerX, centerY, width, height, Arrays.asList(decorator));
  }

  public DrawableRectangle(int centerX, int centerY, int width, int height, Collection<? extends Decorator> decorators) {
    this.decorators.addAll(decorators);
    this.center = new Point(centerX, centerY);

    int x = centerX - (width/2);
    int y = centerY - (width/2);
    
    points.add(new Point(x, y));
    points.add(new Point(x, y+height));
    points.add(new Point(x+width, y+height));
    points.add(new Point(x+width, y));
  }

  @Override
  public String getName() {
    return "Rectangle";
  }

  @Override
  public Point getCenter() {
    return center;
  }
  
  @Override
  public void draw(DrawingBoard drawingBoard) {
    strategy.draw(drawingBoard, true, points);
  }

  @Override
  public Collection<Decorator> getDecorators() {
    return decorators;
  }
}
