public class RobotMain {

    public static void main(String[] args) {

        TableObject tableObject = new TableObject(5, 5);
        RoboObject roboObject = new RoboObject();
        RobotActionUtility robotActionUtility = new RobotActionUtility(roboObject, tableObject);
        if (args.length == 0) {
            System.out.println("No inputs provided. Pass inputs as arguments.");
            return;
        }
        if (!args[0].startsWith("PLACE")) {
            System.out.println("Command should Start with PLACE");
        }
        String direction = null;
        for (String command : args) {
            command = command.trim();

            try {

                if (command.startsWith("PLACE")) {
                    String[] parts = command.substring(6).split(",");
                    if (parts.length != 3) {
                        System.out.println("Invalid PLACE command format: " + command);
                        continue;
                    }
                    int x = Integer.parseInt(parts[0].trim());
                    int y = Integer.parseInt(parts[1].trim());
                    direction = parts[2].trim();
                    if (!robotActionUtility.isDirectionValid(direction)) {
                        System.out.println("Invalid direction: " + direction);
                        continue;
                    }
                    robotActionUtility.place(x, y);

                } else if (command.equals("MOVE")) {
                    robotActionUtility.move(direction);

                } else if (command.equals("LEFT")) {
                    direction =  robotActionUtility.left(direction);

                } else if (command.equals("RIGHT")) {
                    direction = robotActionUtility.right(direction);

                } else if (command.equals("REPORT")) {
                    robotActionUtility.report(direction);

                } else if (command.equals("EXIT")) {
                    break;
                } else {
                    System.out.println("Invalid command: " + command);
                }

            } catch (Exception e) {
                System.out.println("Invalid input: " + command);
            }
        }
    }
}