/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawapp;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

/**
 *
 * @author Rasheed
 */
public class Turtle extends Ellipse 
{
//TURTLE
//Rectangle turtle = new Rectangle(10,10,10,10);
Ellipse turtle = new Ellipse(20,10);
  double turtlex=0;
  double turtley=0;
  double rot=0;
  
  ImagePanel image;
  
  public Turtle(ImagePanel image,int x, int y, int r) 
  {
      this.image = image;
      //image.getChildren().add(turtle);
      Integer xI=x;
      Integer yI=y;
      turtlex=xI.doubleValue();
      turtley=yI.doubleValue();
      //Translate t= new Translate(x,y);
      //turtle.setRotate(r);
      rot=r;
      //image.getTransforms().add(t);
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
     
     //System.out.println()
     Line line = new Line(turtlex, turtley, (turtlex+deltaX), (turtley+deltaY));
     image.getChildren().add(line);
     //Translate t=new Translate(deltaX,deltaY);
     //image.getTransforms().add(t);
     turtlex = turtlex +deltaX;
     turtley = turtley +deltaY;
     
     rot = (rot*180)/Math.PI;
}

public void turnLeft(int rota)
{
    rot = rot-rota;
    turtle.setRotate(rot);
}

public void turnRight(int rota)
{
    rot = rot+rota;
    turtle.setRotate(rot);
}
    
}
