package com.example.bootcamp.draw.solution;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

public class Artist {

  public static void main(String...args) {
    new Artist().run();
  }

  private void run() {

    PrintNameDecorator nameDecorator = DrawUtils.name(Color.black);

    List<Drawable> drawables = Arrays.asList(
        new DrawableRectangle(300, 300, 100, 200, nameDecorator, DrawUtils.pen(Color.red)),
        new DrawableRectangle(600, 600, 200, 100, nameDecorator, DrawUtils.pen(Color.green), DrawUtils.fill(Color.blue)),
        new DrawableRectangle(600, 300, 100, 100, nameDecorator, DrawUtils.fill(Color.yellow)),
        new DrawableSquare(300, 600, 50, nameDecorator, DrawUtils.pen(Color.gray)),
        new DrawableLine(new Point(100,100), new Point(800, 800), nameDecorator, DrawUtils.pen(Color.cyan)),
        new DrawableEclipse(700, 700, 150, 50, nameDecorator, DrawUtils.pen(Color.blue)),
        new DrawableCircle(0, 0, 300)
    );
    
    GraphicsEngine engine = new GraphicsEngine();
    engine.setDrawables(drawables);
  }
}
