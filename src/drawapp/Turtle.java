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
public class Turtle {
//TURTLE
    Color lineCol = Color.rgb(0, 0, 0);
    Path path = new Path();
    double turtlex = 0;
    double turtley = 0;
    double rot = 0;
    ImagePanel image;
    private boolean pen = true;

    public Turtle(ImagePanel image, int x, int y, int r) {
        this.image = image;
        MoveTo mt = new MoveTo(x, y);
        path.setTranslateX(x);
        path.setTranslateY(y);
        path.getElements().addAll(mt);
        image.getChildren().add(path);
        Integer xI = x;
        Integer yI = y;
        turtlex = xI.doubleValue();
        turtley = yI.doubleValue();
        rot = r;
    }

    public void startTurtle(int x, int y, int rota) {
        new Turtle(image, x, y, rota);
    }

    public void forward(int dist) {
        rot = (rot * Math.PI) / 180;
        double sine = Math.sin(rot);
        double cosine = Math.cos(rot);
        double deltaX = cosine * dist;
        double deltaY = sine * dist;
        if (pen) {
            LineTo line = new LineTo((turtlex + deltaX), (turtley + deltaY));
            path.getElements().add(line);
        } else {
            MoveTo line = new MoveTo((turtlex + deltaX), (turtley + deltaY));
            path.getElements().add(line);
        }
        turtlex = turtlex + deltaX;
        turtley = turtley + deltaY;

        rot = (rot * 180) / Math.PI;
    }

    public void turnLeft(int rota) {
        rot = rot - rota;
    }

    public void turnRight(int rota) {
        rot = rot + rota;
    }

    public void penUp() {
        this.pen = false;
    }

    public void penDown() {
        this.pen = true;
    }
}
