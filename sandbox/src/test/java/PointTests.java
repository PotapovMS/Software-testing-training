import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

/**
 * Created by Максим on 17.04.2016.
 */
public class PointTests {
  @Test
  public void TestPointDistance (){
    Point p1 = new Point(4, 8);
    Point p2 = new Point(1, 4);
    Assert.assertEquals(p1.distance(p1,p2), 5.0);
    Point p3 = new Point(0, 0);
    Point p4 = new Point(10, 0);
    Assert.assertEquals(p3.distance(p3,p4), 10.0);
  }
}
