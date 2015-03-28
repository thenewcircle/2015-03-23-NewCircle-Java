package com.example.bootcamp.draw.lab.drawable;

public enum ShapeType {

  Circle("Circle"),
  Eclipse("Eclipse"),
  Square("Square"),
  Rectangle("Rectangle"),
  Line("Line"),
  StickMan("Stick Man");

  private final String label;
  
  private ShapeType(String label) {
    this.label = label;
  }
  
  public String getLabel() {
    return label;
  }
  
  public String toString() {
    return getLabel();
  }

  public boolean isCircle() {
    return this == Circle;
  }

  public boolean isNotCircle() {
    return this != Circle;
  }

  public boolean isEclipse() {
    return this == Eclipse;
  }

  public boolean isSquare() {
    return this == Square;
  }

  public boolean isRectangle() {
    return this == Rectangle;
  }
  
  public boolean isLine() {
    return this == Line;
  }
  
  public boolean isStickMan() {
    return this == StickMan;
  }
}
