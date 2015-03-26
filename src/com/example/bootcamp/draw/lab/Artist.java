package com.example.bootcamp.draw.lab;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import com.example.bootcamp.draw.lab.decorator.Decorator;
import static com.example.bootcamp.draw.lab.decorator.DrawUtils.*;
import com.example.bootcamp.draw.lab.drawable.*;


public class Artist {

  public static void main(String...args) {
    new Artist().run();
  }

  private void run() {

    int startX = 50;
    
    Decorator nameDecorator = name(Color.black);
    DrawableStickMan stickMan = new DrawableStickMan(startX, 700, nameDecorator);
    
    List<Drawable> drawables = Arrays.asList(
        new DrawableRectangle(300, 300, 100, 200, nameDecorator, pen(Color.red), fill(Color.magenta)),
        new DrawableSquare(600, 600, 100, nameDecorator, fill(Color.green)),
        new DrawableLine(new Point(200,300), new Point(600,600), nameDecorator),
        new DrawableCircle(500, 300, 25, nameDecorator),
        new DrawableEclipse(600, 300, 25, 100, nameDecorator),
        stickMan
    );
    
    GraphicsEngine engine = new GraphicsEngine();
    engine.setDrawables(drawables);


    new Thread(new Runnable() {
      public void run() {
        for (int x = startX; x < 1024; x += 30) {
          try {
            stickMan.setX(x);
            Thread.sleep(250);
            engine.repaint();
            
          } catch (InterruptedException e) {
            Thread.interrupted();
          }
        }
      }
    }).start();
  }
}
