package com.example.bootcamp.draw.lab;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
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
  
  /**
   * <br>
   * @throws Exception
   */
  private void run() throws Exception {
    
    Decorator nameDecorator = name(Color.black);

    Map<ShapeType, List<Drawable>> map = new EnumMap<>(ShapeType.class);
    
    int x = 0;
    int y = 100;
    final int step = 200;
    
    map.put(ShapeType.Circle, Arrays.asList(
        new DrawableCircle(x += step, y, 25, nameDecorator, fill(Color.red)),
        new DrawableCircle(x += step, y, 25, nameDecorator, fill(Color.yellow)),
        new DrawableCircle(x += step, y, 25, nameDecorator, fill(Color.green)),
        new DrawableCircle(x += step, y, 25, nameDecorator, fill(Color.blue)),
        new DrawableCircle(x += step, y, 25, nameDecorator, fill(Color.black))
    ));

    x = 0;
    y += step;
    
    map.put(ShapeType.Eclipse, Arrays.asList(
        new DrawableEclipse(x += step, y, 25, 100, nameDecorator, fill(Color.black)),
        new DrawableEclipse(x += step, y, 25, 100, nameDecorator, fill(Color.red)),
        new DrawableEclipse(x += step, y, 25, 100, nameDecorator, fill(Color.yellow)),
        new DrawableEclipse(x += step, y, 25, 100, nameDecorator, fill(Color.green)),
        new DrawableEclipse(x += step, y, 25, 100, nameDecorator, fill(Color.blue))
    ));

    x = 0;
    y += step;
    
    map.put(ShapeType.Square, Arrays.asList(
        new DrawableSquare(x += step, y, 100, nameDecorator, fill(Color.blue)),
        new DrawableSquare(x += step, y, 100, nameDecorator, fill(Color.green)),
        new DrawableSquare(x += step, y, 100, nameDecorator, fill(Color.yellow)),
        new DrawableSquare(x += step, y, 100, nameDecorator, fill(Color.red)),
        new DrawableSquare(x += step, y, 100, nameDecorator, fill(Color.black))
    ));
    

    List<Drawable> list = new ArrayList<>();

    // map.entrySet().stream().filter(es -> es.getKey() != ShapeType.Circle).forEach(es -> list.addAll(es.getValue()));
    
    map.entrySet()
       .stream()
       .filter( entry -> entry.getKey().isCircle() )
       .forEach( entry -> list.addAll(entry.getValue()) );
    
    
/*    for (ShapeType type : map.keySet()) {
      List<Drawable> temp = map.get(type);
      list.addAll(temp);
    }
*/    
/*    for (Map.Entry<ShapeType, List<Drawable>> entry : map.entrySet()) {
      ShapeType type = entry.getKey();
      List<Drawable> temp = entry.getValue();
      list.addAll(temp);
      
//      Object o = entry.getValue();
//      List l = (List)o;
//      for (Object ox : l) {
//        Drawable d = (Drawable)ox;
//      }
    }
*/    
    drawables = new LinkedBlockingQueue<Drawable>(list);
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




