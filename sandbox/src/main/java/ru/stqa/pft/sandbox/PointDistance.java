package ru.stqa.pft.sandbox;

/**
 * Created by Максим on 16.04.2016.
 */
public class PointDistance {
  public static void main(String[] args) {
    Point p1 = new Point(4, 8);
    Point p2 = new Point(1, 4);
    System.out.println("Расстояние между двумя точками на плоскости с координатами " + p1.x + ";" + p1.y + " и " + p2.x + ";" + p2.y + " = " + p2.distance(p1, p2));
    Point p3 = new Point(1, 0);
    Point p4 = new Point(10, 8);
    System.out.println("Расстояние между двумя точками на плоскости с координатами " + p3.x + ";" + p3.y + " и " + p4.x + ";" + p4.y + " = " + p3.distance(p3, p4));
    Point p5 = new Point(3, 9);
    Point p6 = new Point(4, 11);
    System.out.println("Расстояние между двумя точками на плоскости с координатами " + p5.x + ";" + p5.y + " и " + p6.x + ";" + p6.y + " = " + p5.distance(p5, p6));
  }
}
