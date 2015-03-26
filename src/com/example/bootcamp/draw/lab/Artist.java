package com.example.bootcamp.draw.lab;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class Artist {

  public static void main(String...args) {
    new Artist().run();
  }

  private void run() {

    PrintNameDecorator nameDecorator = new PrintNameDecorator(Color.black);
    
    List<Drawable> drawables = Arrays.asList(
        new DrawableRectangle(300, 300, 100, 200, nameDecorator, new PenColorDecorator(Color.red)),
        new DrawableRectangle(600, 600, 100, 100, nameDecorator, new SolidFillDecorator(Color.green))
    );
    
    GraphicsEngine engine = new GraphicsEngine();
    engine.setDrawables(drawables);
  }
}
