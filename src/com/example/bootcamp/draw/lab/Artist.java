package com.example.bootcamp.draw.lab;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

public class Artist {

  public static void main(String...args) {
    new Artist().run();
  }

  private void run() {

    PrintNameDecorator nameDecorator = new PrintNameDecorator(Color.black);
    
    List<Drawable> drawables = Arrays.asList(
        new DrawableRectangle(300, 300, 100, 200, nameDecorator, new PenColorDecorator(Color.red), new SolidFillDecorator(Color.magenta)),
        new DrawableSquare(600, 600, 100, nameDecorator, new SolidFillDecorator(Color.green)),
        new DrawableLine(new Point(0,0), new Point(600,600), nameDecorator),
        new DrawableCircle(500, 300, 25, nameDecorator),
        new DrawableEclipse(600, 300, 25, 100, nameDecorator)
    );
    
    GraphicsEngine engine = new GraphicsEngine();
    engine.setDrawables(drawables);
  }
}
