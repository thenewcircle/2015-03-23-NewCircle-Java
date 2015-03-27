package com.example.bootcamp.draw.lab.drawable;

import java.awt.Point;
import java.util.Collection;

import com.example.bootcamp.draw.lab.DrawingBoard;
import com.example.bootcamp.draw.lab.decorator.Decorator;

public interface Drawable extends Comparable<Drawable> {

  ShapeType getShapeType();
  
  Point getCenter();
  
  void draw(DrawingBoard drawingBoard);
  
  Collection<Decorator> getDecorators();

  String getName();
}
