package com.example.bootcamp.draw.lab;

import java.awt.geom.Ellipse2D;

public class EclipseDrawingStrategy {

  public void draw(DrawingBoard drawingBoard, int centerX, int centerY, int width, int height) {

    int x = centerX - (width/2);
    int y = centerY - (height/2);
    
    Ellipse2D elipse = new Ellipse2D.Double(x, y, width, height); 
    drawingBoard.drawShape(elipse);  
  }
}
