package com.example.bootcamp.draw.lab;

import java.util.Collection;

public interface Drawable {

  void draw(DrawingBoard drawingBoard);
  
  Collection<Decorator> getDecorators();
}
