/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawapp;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author Rasheed
 */
public class Turtle extends Ellipse 
{
//TURTLE
Color lineCol = Color.rgb(0, 0, 0);
Path path= new Path();
Ellipse turtle;
  double turtlex=0;
  double turtley=0;
  double rot=0;  
  ImagePanel image;
  
  public Turtle(ImagePanel image,int x, int y, int r) 
  {
      this.image = image;
      MoveTo mt = new MoveTo(x,y);
      //LineTo line = new LineTo(x,y);
      path.getElements().addAll(mt);
      image.getChildren().add(path);
      Integer xI=x;
      Integer yI=y;
      turtlex=xI.doubleValue();
      turtley=yI.doubleValue();
      rot=r;
  }

public void startTurtle(int x,int y, int rota)
{
   new Turtle(image, x,y,rota);
}

public void forward(int dist)
{
     rot= (rot*Math.PI)/180;
     double sine = Math.sin(rot);
     double cosine = Math.cos(rot);
     double deltaX = cosine * dist;
     double deltaY = sine * dist;
     LineTo line = new LineTo((turtlex+deltaX), (turtley+deltaY));
     path.getElements().add(line);
     turtlex = turtlex +deltaX;
     turtley = turtley +deltaY;
     
     rot = (rot*180)/Math.PI;
}

public void turnLeft(int rota)
{
    rot = rot-rota;
    //turtle.setRotate(rot);
}

public void turnRight(int rota)
{
    rot = rot+rota;
    //turtle.setRotate(rot);
}

public void penUp()
{
    System.out.println("penup");
}
public void penDown()
{
    System.out.println("penDown");
}
    
}
