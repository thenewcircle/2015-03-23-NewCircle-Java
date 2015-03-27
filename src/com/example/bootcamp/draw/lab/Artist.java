package com.example.bootcamp.draw.lab;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

  //ExecutorService service = Executors.newWorkStealingPool();
  ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(drawables.size());
  
  private void run() throws Exception {
    
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

  
    ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(drawables.size());
    for (int i = 0; i < 100; i++) {
      scheduledService.scheduleAtFixedRate(this::animate, 0, 1, TimeUnit.NANOSECONDS);
    };
  }
  
  private void animate() {
    try {
      Drawable drawable;
      drawable = drawables.take();
      engine.repaint();
      Thread.sleep(random.nextInt(2_000));
      drawables.put(drawable);
      Thread.sleep(random.nextInt(2_000));  

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}




