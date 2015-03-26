package com.example.bootcamp.draw.lab.decorator;

import com.example.bootcamp.draw.lab.DrawingBoard;
import com.example.bootcamp.draw.lab.drawable.Drawable;

public interface Decorator {

  void decorate(DrawingBoard drawingBoard, Drawable drawable);

}
