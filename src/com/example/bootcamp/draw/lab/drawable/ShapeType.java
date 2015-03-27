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
}
