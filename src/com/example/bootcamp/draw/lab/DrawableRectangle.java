package com.example.bootcamp.draw.lab;

import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DrawableRectangle implements Drawable {

  private final List<Point> points = new ArrayList<>();
  private final List<Decorator> decorators = new ArrayList<>();
  
  public DrawableRectangle(int centerX, int centerY, int width, int height, Decorator...decorator) {
    this(centerX, centerY, width, height, Arrays.asList(decorator));
  }

  public DrawableRectangle(int centerX, int centerY, int width, int height, Collection<? extends Decorator> decorators) {
    this.decorators.addAll(decorators);
    
    int x = centerX - (width/2);
    int y = centerY - (width/2);
    
    points.add(new Point(x, y));
    points.add(new Point(x, y+height));
    points.add(new Point(x+width, y+height));
    points.add(new Point(x+width, y));
  }

  @Override
  public void draw(DrawingBoard drawingBoard) {

    GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, points.size());

    Iterator<Point> it = points.iterator();
    Point point = it.next();
    polygon.moveTo(point.getX(), point.getY());
    
    while (it.hasNext()) {
      point = it.next();
      polygon.lineTo(point.getX(), point.getY());
    };

    polygon.closePath();

    drawingBoard.drawShape(polygon);  
  }

  @Override
  public Collection<Decorator> getDecorators() {
    return decorators;
  }
}
