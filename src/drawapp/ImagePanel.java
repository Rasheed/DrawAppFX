package drawapp;

import java.awt.Color;
import java.awt.Graphics;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ImagePanel extends HBox
{
  String colorst;
  private HBox hb;
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
public void setColour(Color colour)
{   
   Integer blue=colour.getBlue();
   Integer green=colour.getGreen();
   Integer red=colour.getRed();
   String hex = String.format("#%02x%02x%02x", red, green, blue);
   colorst=hex;
}

  public void drawLine(int x1, int y1, int x2, int y2)
  {
    Line line = new Line();
    line.setStartX(x1);
    line.setStartY(y1);
    line.setEndX(x2);   
    line.setEndY(y2);
    line.setStroke(Paint.valueOf(colorst));
    image.getChildren().add(line);
    colorst="000000";
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
rectFill.setFill(Paint.valueOf(colorst));
image.getChildren().add(rectFill);
colorst="#000000";
}
public void drawString(int x, int y, String s)
{
Text t = new Text(x,y,s);
image.getChildren().add(t);
}
public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)
{
Arc arc = new Arc(x,y,width/2,height/2,startAngle,arcAngle);
arc.setStroke(Paint.valueOf(colorst));
arc.setFill(Paint.valueOf("00000000"));
image.getChildren().add(arc);
colorst="000000";
}
public void drawOval(int x, int y, int width, int height)
{
Ellipse oval = new Ellipse(x,y,width,height);
oval.setStroke(Paint.valueOf("colorst"));
oval.setFill(Paint.valueOf("00000000"));
image.getChildren().add(oval);
}
}
