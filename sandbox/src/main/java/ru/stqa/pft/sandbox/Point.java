package ru.stqa.pft.sandbox;

/**
 * Created by Максим on 16.04.2016.
 */
public class Point {
  double x;
  double y;

  public Point (double x, double y){
    this.x = x;
    this.y = y;
  }

  public double distance(Point a, Point b) {
    double dx = a.x - b.x;
    double dy = a.y - b.y;
    return Math.sqrt(dx * dx + dy * dy);
  }
}
