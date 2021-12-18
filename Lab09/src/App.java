import Graphics3D.AbstractShapeStage;
import Graphics3D.Cylinder;
import Graphics3D.Rectangle;
import Graphics3D.Sphere;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 500;
    public static void main(String[] args) { launch(args);}

    @Override
    public void start(Stage primaryStage) {
        AbstractShapeStage[] shapes = {
            new Sphere(WIDTH, HEIGHT),
            new Rectangle(WIDTH, HEIGHT),
            new Cylinder(WIDTH, HEIGHT)
        };

        for (AbstractShapeStage shape : shapes) {
            shape.showStage();
        }
    }
}
