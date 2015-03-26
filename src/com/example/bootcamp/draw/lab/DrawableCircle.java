package com.example.bootcamp.draw.lab;

import java.util.Arrays;
import java.util.Collection;

public class DrawableCircle extends DrawableEclipse {

  public DrawableCircle(int centerX, int centerY, int radius, Decorator...decorator) {
    this(centerX, centerY, radius, Arrays.asList(decorator));
  }

  public DrawableCircle(int centerX, int centerY, int radius, Collection<? extends Decorator> decorators) {
    super(centerX, centerY, radius*2, radius*2, decorators);
  }

  @Override
  public String getName() {
    return "Circle";
  }
}
