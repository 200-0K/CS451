package Graphics3D;

import Custom.SmartGroup;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Sphere extends AbstractShapeStage {
    public Sphere(int width, int height) {
        shape = new javafx.scene.shape.Sphere(50);
        SmartGroup group = new SmartGroup();
        group.getChildren().add(shape);
        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, width, height);
        scene.setFill(Color.BEIGE);
        scene.setCamera(camera);
        shape.translateXProperty().set(width / 2);
        shape.translateYProperty().set(height / 2);
        
        this.addEventHandler(KeyEvent.KEY_PRESSED, group::handleTransformations);

        this.setTitle("Sphere");
        this.setScene(scene);
    }
}
