package com.example.bootcamp.draw.lab;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.example.bootcamp.draw.lab.decorator.Decorator;

import static com.example.bootcamp.draw.lab.decorator.DrawUtils.*;

import com.example.bootcamp.draw.lab.drawable.*;


public class Artist {

  public static void main(String...args) {
    try {
      new Artist().run();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private BlockingQueue<Drawable> drawables;
  private GraphicsEngine engine;
  private Random random = new Random(System.currentTimeMillis());

  private void run() {
    
    Decorator nameDecorator = name(Color.black);
    
//    List<Drawable> drawables = Arrays.asList(
    List<Drawable> temp = Arrays.asList(
        new DrawableRectangle(300, 300, 100, 200, nameDecorator, pen(Color.red), fill(Color.magenta)),
        new DrawableSquare(600, 600, 100, nameDecorator, fill(Color.green)),
        new DrawableLine(new Point(200,300), new Point(600,600), nameDecorator),
        new DrawableCircle(500, 300, 25, nameDecorator),
        new DrawableEclipse(600, 300, 25, 100, nameDecorator)
    );
    
    drawables = new LinkedBlockingQueue<Drawable>(temp);
    
    engine = new GraphicsEngine(drawables);
    
 // Now we can replace the Runnable class and all the boiler 
 // plate that comes with a lambda expression. The lambda will
 // assume the same signature of the Runnable because it is 
 // a "functional interface".
 // 
 // A functional interface is any interface that contains only 
 // one abstract method. (A functional interface may contain 
 // one or more default methods or static methods.) A good 
 // example of default method is forEach(..);

//    class Animator implements Runnable {
//      @Override
//      public void run() {

    Runnable runnable = () -> {
      try {
        Drawable drawable;
        for (;;) {
          drawable = drawables.take();
          engine.repaint();
          Thread.sleep(random.nextInt(2_000));
          drawables.put(drawable);
          Thread.sleep(random.nextInt(2_000));
        }        
      } catch (InterruptedException e) {
        Thread.interrupted();
      }
    }; 
    
    new Thread(runnable).start();
    new Thread(runnable).start();
    new Thread(runnable).start();
  }
}




