# Rectangle Solution by Ron Khera

This project attempts to fulfill the requirements laid out in the 'Rectangles Programming Sample.pdf'.
Please refer to this for the primary objectives.

I have taken a brute force approach in solving this challenge, ie no mathematical formula's have been used.
Instead, I wrote tests and draw diagrams to build up the code solution.
I decided to write methods to identify rectangles that should be skipped when checking for the functions.
For example, if the other rectangle is above this rectangle is can intersect it and should be skipped. 

I am aware of the java.awt.Rectangle class and have NOT looked at its implementation for the functions of 
'contains' or 'intersects'. I did not want its implementation to influence my solution.

# Building and Running this project
When the project jar is executed the functions of 'contains', 'adjacently' and 'intersects' are run against 
some hard coded dummy data. The user can pass custom rectangles as program arguments.
There are 24 unit tests that cover these functions, some move a rectangle horizontally, 
vertically and diagonally across another rectangle. However, these tests could be more varied but my free time is 
a constraint.

# Clone the project
  git clone git@github.com:ScottiePower/Rectangle.git

# Build Project
  cd rectangle

  mvn clean install

# Execute project
  cd target

  java -jar rectangle-1.0-SNAPSHOT.jar

# Using custom rectangles
  Note: If you wish to pass custom rectangles, Please use format '(X,Y:X,Y)' for each rectangle.
  The first X,Y coordinates represent the bottom left corner and the second X,Y coordinates represent the top right corner.

  Example: java -jar rectangle-1.0-SNAPSHOT.jar "(1,1:6,4)" "(2,1:4,3)"