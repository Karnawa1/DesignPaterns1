import com.SDC.model.Point;
import com.SDC.model.Tetrahedron;
import com.SDC.service.ShapeService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TetrahedronTest {

    @Test
    public void testTetrahedronSurfaceArea() {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(1, 0, 0);
        Point p3 = new Point(0, 1, 0);
        Point p4 = new Point(0, 0, 1);
        Tetrahedron tetrahedron = new Tetrahedron(p1, p2, p3, p4);
        double expected = Math.sqrt(3);
        double delta = 0.001;

        double actual = new ShapeService().calculateSurfaceArea(tetrahedron);

        assertEquals(expected, actual, delta);
    }
}