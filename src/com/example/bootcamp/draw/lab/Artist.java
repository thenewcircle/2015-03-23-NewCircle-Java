package com.example.bootcamp.draw.lab;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
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

  ExecutorService service = Executors.newWorkStealingPool();
  
  private void run() throws Exception {
    
    Decorator nameDecorator = name(Color.black);

    int x = 0;
    final int step = 200;
    final int y = 300;
    
    List<Drawable> temp = Arrays.asList(
        new DrawableRectangle(x += step, y, 100, 200, nameDecorator, pen(Color.red), fill(Color.magenta)),
        new DrawableSquare(x += step, y, 100, nameDecorator, fill(Color.green)),
        new DrawableLine(new Point(x += step, y), new Point(x += step, y), nameDecorator, fill(Color.blue)),
        new DrawableCircle(x += step, y, 25, nameDecorator, fill(Color.red)),
        new DrawableCircle(x += step, y, 25, nameDecorator, fill(Color.yellow)),
        new DrawableEclipse(x += step, y, 25, 100, nameDecorator, fill(Color.black))
    );
   
    SortedSet<Drawable> set = new TreeSet<>(temp);

    drawables = new LinkedBlockingQueue<Drawable>(temp);
    engine = new GraphicsEngine(drawables);

  
    ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(drawables.size());
    for (int i = 0; i < 1; i++) {
      scheduledService.scheduleAtFixedRate(this::animate, 0, 1, TimeUnit.NANOSECONDS);
    };
  }
  
  private void animate() {
    try {
      Drawable drawable;
      drawable = drawables.take();
      engine.repaint();
      Thread.sleep(500);
      drawables.put(drawable);
      Thread.sleep(500);  

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}




