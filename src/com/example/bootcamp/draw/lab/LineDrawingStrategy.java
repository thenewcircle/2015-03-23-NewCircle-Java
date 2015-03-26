package com.example.bootcamp.draw.lab;

import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.Collection;
import java.util.Iterator;

public class LineDrawingStrategy {

  public void draw(DrawingBoard drawingBoard, boolean close, Collection<Point> points) {

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
}
