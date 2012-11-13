package drawapp;

import java.awt.Graphics;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class ImagePanel extends HBox
{
  Paint colorst=Color.BLACK;
  private HBox hb;
  Rectangle turtle = new Rectangle(10,10,10,10);
  int turtlex=0;
  int turtley=0;
  double rot=0;
  private Group image=new Group();
  private Graphics graphics;

  public ImagePanel(int width, int height)
  {
    setImageSize(width, height);
  }

  private void setImageSize(int width, int height)
  {
    this.add(image);
    this.setPrefHeight(height);
    this.setPrefWidth(width);
    ImagePanel.setHgrow(image, Priority.NEVER);
    //ImagePanel.setgrow(image, Priority.NEVER);

    //this.setMaxHeight(height);
    //this.setMaxWidth(width);
  }
  
  public void add(Node g)
  {
    this.getChildren().add(g);
  }

  public void setBackgroundColour(String st)
{ 
image.setStyle("-fx-fill: "+st+";");
}
public void clear(Color colour)
{
setBackgroundColour("00000000");
}

public void setGradient(Color start, Color finish)
{
    Stop[] stops = new Stop[] { new Stop(0, start), new Stop(1, finish)};
    colorst = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
}

public void setColour(Color colour)
{   
   //Integer blue=colour.getBlue();
   //Integer green=colour.getGreen();
   //Integer red=colour.getRed();
   //String hex = String.format("#%02x%02x%02x", red, green, blue);
   colorst=colour;
}

  public void drawLine(int x1, int y1, int x2, int y2)
  {
    Line line = new Line();
    line.setStartX(x1);
    line.setStartY(y1);
    line.setEndX(x2);   
    line.setEndY(y2);
    line.setStroke(colorst);
    image.getChildren().add(line);
    colorst=Color.BLACK;
  }
  
  public void drawRoundRect(int x1, int y1, int x2, int y2,int r)
  {
      Rectangle rect = new Rectangle(x1,y1,x2,y2);
      rect.setArcWidth(r);
      rect.setArcHeight(r);
      rect.setStroke(Paint.valueOf("000000"));
      rect.setFill(Paint.valueOf("00000000"));
      image.getChildren().add(rect);
  }
  
  public void fillRoundRect(int x1, int y1, int x2, int y2,int r)
  {
      Rectangle rect = new Rectangle(x1,y1,x2,y2);
      rect.setArcWidth(r);
      rect.setArcHeight(r);
      rect.setFill(colorst);
      image.getChildren().add(rect);
      colorst=Color.BLACK;
  }
public void drawRect(int x1, int y1, int x2, int y2)
{
Rectangle rect = new Rectangle(x1,y1,x2,y2);
rect.setStroke(Paint.valueOf("000000"));
rect.setFill(Paint.valueOf("00000000"));
image.getChildren().add(rect);
}
public void fillRect(int x1, int y1, double x2, double y2)
{
Rectangle rectFill = new Rectangle(x1,y1,x2,y2);
rectFill.setFill(colorst);
image.getChildren().add(rectFill);
colorst=Color.BLACK;
}
public void drawString(int x, int y, String s)
{
Text t = new Text(x,y,s);
image.getChildren().add(t);
}
public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)
{
Arc arc = new Arc(x,y,width/2,height/2,startAngle,arcAngle);
arc.setStroke(colorst);
arc.setFill(Paint.valueOf("00000000"));
image.getChildren().add(arc);
colorst=Color.BLACK;
}
public void drawOval(int x, int y, int width, int height)
{
Ellipse oval = new Ellipse(x,y,width,height);
oval.setStroke(colorst);
oval.setFill(Paint.valueOf("00000000"));
image.getChildren().add(oval);
colorst=Color.BLACK;
}

public void drawImage(int x, int y, int width, int height,String name)
{
 
Image image4 = new Image("file:"+name, width, height, false, false);
 ImageView imgView = new ImageView(image4);
 image.getChildren().add(imgView);
 image.setLayoutX(x);
 image.setLayoutY(y);
}

//TURTLE

public void startTurtle(int x,int y, int rota)
{
    turtlex=x;
    turtley=y;
    Translate t= new Translate(x,y);
    turtle.setRotate(rota);
    rot=rota;
    turtle.setFill(colorst);
    image.getChildren().add(turtle);
    image.getTransforms().add(t);
    colorst=Color.BLACK;
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

/*public void turnLeft(int rota)
{
    double radians = Math.toRadians(rota);
    rot = rot-radians;
    Rotate r = new Rotate(-rota);
    turtle.getTransforms().add(r);
    //turtle.setRotate(rota);
}*/

}
