package com.example.bootcamp.draw.lab;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

import com.example.bootcamp.draw.lab.drawable.DrawableCircle;

public class ArtistTests {

  @Test
  public void testCircle() {
    DrawableCircle circleA = new DrawableCircle(100, 100, 100, Collections.emptyList());
    DrawableCircle circleB = new DrawableCircle(100, 100, 100, Collections.emptyList());

    Assert.assertEquals(circleA, circleB);
  }
}
