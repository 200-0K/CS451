package Graphics3D;

import Custom.SmartGroup;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;

public class Rectangle extends AbstractShapeStage {
    public Rectangle(int width, int height) {
        shape = new Box(100, 20, 50);
        SmartGroup group = new SmartGroup();
        group.getChildren().add(shape);
        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, width, height);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);
        group.translateXProperty().set(width / 2);
        group.translateYProperty().set(height / 2);
        
        this.addEventHandler(KeyEvent.KEY_PRESSED, group::handleTransformations);

        this.setTitle("Rectangle");
        this.setScene(scene);
    }
}
