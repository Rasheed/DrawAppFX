package drawapp;

import java.awt.Color;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.layout.*;

/**
 *
 * @author Rasheed
 */
public class MainWindow {

    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 600;
    private int width;
    private int height;
    ImagePanel imageRegion;
    String cssDefault = "-fx-border-color: black;\n"
                + "-fx-border-insets: 5;\n"
                + "-fx-border-width: 0;\n";
    
    private TextArea textarea = new TextArea();
    private Button closeButton = new Button("CloseWindow");

    public MainWindow(Stage stage) {
        this(stage, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public MainWindow(Stage primaryStage, int width, int height) {
        primaryStage.setTitle("DrawApp");
        Group root = new Group();
        Scene scene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        GridPane gridpane = buildGUI();
        root.getChildren().add(gridpane);
        primaryStage.setScene(scene);
    }

    private GridPane buildGUI() {
        GridPane gridpane = new GridPane();
        gridpane.setHgap(10);
        gridpane.setVgap(0);
        
        //Adding ImagePanel
        imageRegion = new ImagePanel(600,400);
        imageRegion.setStyle(cssDefault);
        gridpane.add(imageRegion, 0, 0);
        // Text area for CSS editor 
        textarea.setWrapText(true);
        textarea.setPrefWidth(600);
        textarea.setPrefHeight(150);
        GridPane.setHalignment(textarea, HPos.CENTER);
        gridpane.add(textarea, 0, 1);
        postMessage("Drawing Completed!!");
        

        ImagePanel pictureRegion2 = new ImagePanel(600,50);
        pictureRegion2.setAlignment(Pos.CENTER);
        pictureRegion2.setBackgroundColour("#E8E8E8");

        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        pictureRegion2.add(closeButton);
        gridpane.add(pictureRegion2, 0, 2);

        return gridpane;
    }

    public ImagePanel getImagePanel() 
    {
        return imageRegion;
    }

    public void postMessage(final String s) 
    {
        textarea.setText(s);
    }
}
