package com.example.bootcamp.draw.solution;

import java.awt.Point;
import java.util.Collection;

public interface Drawable {

  Point getCenter();

  void draw(DrawingBoard drawingBoard);
  
  Collection<Decorator> getDecorators();

  String getName();
}
