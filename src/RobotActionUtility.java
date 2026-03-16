import java.util.Arrays;
import java.util.List;

public class RobotActionUtility {


    private TableObject tableObject;
    private RoboObject roboObject;
    private static final List<String> VALID_DIRECTIONS =
            Arrays.asList("NORTH","SOUTH","EAST","WEST");
    public RobotActionUtility(RoboObject roboObject, TableObject tableObject) {
        this.tableObject = tableObject;
        this.roboObject  = roboObject;
    }

    public void place(int x, int y) {
        if (isPositionValid(x, y)) {
            this.roboObject.setX(x);
            this.roboObject.setY(y);
            this.roboObject.setPlaced(true);
        }
    }

    public void move(String direction) {
        if (!roboObject.isPlaced()) return;

        int newX = roboObject.getX();
        int newY = roboObject.getY();

        switch (direction) {
            case "NORTH": newY++; break;
            case "SOUTH": newY--; break;
            case "EAST":  newX++; break;
            case "WEST":  newX--; break;
        }

        if (isPositionValid(newX, newY)) {
            roboObject.setX(newX);
            roboObject.setY(newY);
        }
    }

    public String left(String direction) {
        if (!roboObject.isPlaced()) return direction;
        switch (direction) {
            case "NORTH": return "WEST";
            case "WEST": return "SOUTH";
            case "SOUTH": return "EAST";
            case "EAST": return "NORTH";
            default: return direction;
        }
    }

    public String right(String direction) {
        if (!roboObject.isPlaced()) return direction;
        switch (direction) {
            case "NORTH": return "EAST";
            case "EAST": return "SOUTH";
            case "SOUTH": return "WEST";
            case "WEST": return "NORTH";
            default: return direction;
        }
    }

    public void report(String direction) {
        if (!roboObject.isPlaced()) return;
        System.out.println(roboObject.getX() + "," + roboObject.getY() + "," + direction);
    }

    private boolean isPositionValid(int x, int y) {

        return x >= 0 && x < tableObject.getWidth() && y >= 0 && y < tableObject.getHeight();
    }
    public  boolean isDirectionValid(String direction) {
        return  direction != null && VALID_DIRECTIONS.contains(direction);
    }
}