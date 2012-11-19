#include "graphics.h"

int main(void)
{ 
  startTurtle(100, 100, 30);
  penDown();
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  penUp();
  forward(200);
  turnRight(30);
  penDown();
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  return 0;
}