#include "graphics.h"

int main(void)
{
  setGradient(blue,yellow);
  fillRect(0, 0, 600, 600);
  //drawImage(50,50,900,500,"Meek.jpeg");
  //fillRoundRect(50,50,70,70,20);
  
  /*startTurtle(50, 20, 30);
  forward(100);//TESTER
  turnLeft(30);
  forward(100);
  turnRight(30);
  forward(100);*/
  setDimension(600,600);
  return 0;
}