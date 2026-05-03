/* Isaac St Hubert 05/02/2026 Module 7.2
 * This program demonstrates external CSS styling with JavaFX circles
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStyleDemo extends Application {

  @Override
  public void start(Stage primaryStage) {

    HBox hBox = new HBox(5);
    Scene scene = new Scene(hBox, 340, 180);

    scene.getStylesheets().add("style.css");

    Pane pane1 = new Pane();

    Circle circle1 = new Circle(50, 50, 30);
    Circle circle2 = new Circle(150, 50, 30);
    Circle circle3 = new Circle(100, 130, 30);

    pane1.getChildren().addAll(circle1, circle2, circle3);

    pane1.getStyleClass().add("border");

    circle1.getStyleClass().add("whitecircle");
    circle2.getStyleClass().add("whitecircle");

    circle3.setId("redcircle");

    Pane pane2 = new Pane();

    Circle circle4 = new Circle(100, 130, 30);

    circle4.getStyleClass().addAll("whitecircle", "circleborder");

    circle4.setId("greencircle");

    pane2.getChildren().add(circle4);

    pane2.getStyleClass().add("border");

    hBox.getChildren().addAll(pane1, pane2);

    primaryStage.setTitle("CircleStyleDemo");

    primaryStage.setScene(scene);

    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}