/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawapp;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 *
 * @author Rasheed
 */
public class Turtle extends Ellipse 
{
//TURTLE
//Rectangle turtle = new Rectangle(10,10,10,10);
Ellipse turtle = new Ellipse(20,10);
  int turtlex=0;
  int turtley=0;
  double rot=0;
  
  ImagePanel image;
  
  public Turtle(ImagePanel image,int x, int y, int r) 
  {
      this.image = image;
      image.getChildren().add(turtle);
      turtlex=x;
      turtley=y;
      Translate t= new Translate(x,y);
      turtle.setRotate(r);
      rot=r;
      image.getTransforms().add(t);
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
     
     Translate t=new Translate(deltaX,deltaY);
     image.getTransforms().add(t);
     
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
