# Bouncing-ball-with-velocity-and-energy-lost
This repository is for my Numerical Method Mid Semester Test.

## Repository Structure
```
Main.java - The main running application and create window
Painter.java - Add color to the window backgorund, get window location, add color for ball and get ball location
Listener.java - Create listener function such as mouseClicked, mouseReleased, mouseDragges etc
Dropthread.java - All the logic for ball to bounce with gravity, friction and energy lost as consideration
Time.java - Get ball, mouse moving time
Shapeutils.java - To calculate whether the mouse click is within the ball
```

## Run program
1. Clone this repo

2. Open cmd and type
```
java Main.java
```

## Further improve
* Offset problem (x: -14, y: -37)
* Gradient of the 3D ball
* Add ceiling so ball cant exceed top of the window when using mouseDragged function
* Deformed shape

## Reference
https://github.com/afeldscher/Gravity-Ball-Sim
