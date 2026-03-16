Project Structure:
------------------
- TableObject.java        : Represents the table and its boundaries.
- RoboObject.java         : Represents the robot, its position, direction, and placement state.
- RobotActionUtility.java : Utility class for executing robot commands.
- RobotMain.java          : Main class to run the program with command-line input.
- RobotActionUtilityTest.java : JUnit test suite covering robot commands.

Setup Instructions: (I have developed and tested this task on Windows.)
-------------------
1. Ensure JDK (Java 8 or higher) .
2. JUnit 4 JAR files (`junit-4.13.2.jar` and `hamcrest-core-1.3.jar`) downloaded and accessible in src.
3. cd Robot-Task\src
4. Compile the project classes:
   javac RobotMain.java TableObject.java RoboObject.java RobotActionUtility.java
5. Run the RobotMain class: // Passing commands as Command line arguments
	java RobotMain "PLACE 0,0,NORTH" "MOVE" "RIGHT" "MOVE" "REPORT"  
6. Compile the test class: // replace ; with : on Linux/macOS.
   javac -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar RobotActionUtilityTest.java 
7. Run the JUnit tests: //replace ; with : on Linux/macOS.
   java -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore RobotActionUtilityTest 
