import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class RobotActionUtilityTest {

    private TableObject table;
    private RoboObject robot;
    private RobotActionUtility utility;

    @Before
    public void setUp() {
        table = new TableObject(5, 5);
        robot = new RoboObject();
        utility = new RobotActionUtility(robot, table);
    }

    @Test
    public void testValidPlace() {
        utility.place(1, 1);
        assertTrue(robot.isPlaced());
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
    }

    @Test
    public void testInvalidPlace() {
        utility.place(5, 5);
        assertFalse(robot.isPlaced());
    }
    @Test
    public void testMoveAtrNorthEast() {
        utility.place(4, 4);
        utility.move("NORTH");
        utility.move("EAST");
        assertEquals(4, robot.getX());
        assertEquals(4, robot.getY());
    }
    @Test
    public void testMoveAtSouthEast() {
        utility.place(4, 0);
        utility.move("SOUTH");
        utility.move("EAST");
        assertEquals(4, robot.getX());
        assertEquals(0, robot.getY());
    }

    @Test
    public void testMoveAtNorthWest() {
        utility.place(0, 4);
        utility.move("NORTH");
        utility.move("WEST");
        assertEquals(0, robot.getX());
        assertEquals(4, robot.getY());
    }

    @Test
    public void testMoveNorth() {
        utility.place(2, 2);
        utility.move("NORTH");
        assertEquals(2, robot.getX());
        assertEquals(3, robot.getY());
    }

    @Test
    public void testMoveSouth() {
        utility.place(2, 2);
        utility.move("SOUTH");
        assertEquals(2, robot.getX());
        assertEquals(1, robot.getY());
    }

    @Test
    public void testMoveEast() {
        utility.place(2, 2);
        utility.move("EAST");
        assertEquals(3, robot.getX());
        assertEquals(2, robot.getY());
    }

    @Test
    public void testMoveWest() {
        utility.place(2, 2);
        utility.move("WEST");
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
    }

    @Test
    public void testMoveAtStart() {
        utility.place(0, 0);
        utility.move("SOUTH");
        utility.move("WEST");
        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
    }

    @Test
    public void testMoveIsPlacedFalse() {
        utility.move("NORTH");
        assertFalse(robot.isPlaced());
    }

    @Test
    public void testLeftRotation() {
        utility.place(0, 0);
        String dir = utility.left("NORTH");
        assertEquals("WEST", dir);
    }

    @Test
    public void testRightRotation() {
        utility.place(0, 0);
        String dir = utility.right("NORTH");
        assertEquals("EAST", dir);
    }

    @Test
    public void testRotationIsPlacedFalse() {
        String dir = utility.left("NORTH");
        assertEquals("NORTH", dir);
    }

    @Test
    public void testCommandsMore() {
        utility.place(0, 0);
        utility.move("NORTH");
        String dir = utility.right("NORTH");
        utility.move(dir);
        assertEquals(1, robot.getX());
        assertEquals(1, robot.getY());
    }

    @Test
    public void testDirectionValidation() {
        assertTrue(utility.isDirectionValid("NORTH"));
        assertTrue(utility.isDirectionValid("SOUTH"));
        assertFalse(utility.isDirectionValid("UP"));
        assertFalse(utility.isDirectionValid("DOWN"));
        assertFalse(utility.isDirectionValid("north"));
        assertFalse(utility.isDirectionValid("south"));
    }
}