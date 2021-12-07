package Graphics3D;

import Custom.SmartGroup;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Cylinder extends AbstractShapeStage {
    public Cylinder(int width, int height) {
        shape = new javafx.scene.shape.Cylinder(50, 200);
        SmartGroup group = new SmartGroup();
        group.getChildren().add(shape);
        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, width, height);
        scene.setFill(Color.BURLYWOOD);
        scene.setCamera(camera);
        shape.translateXProperty().set(width / 2);
        shape.translateYProperty().set(height / 2);

        this.addEventHandler(KeyEvent.KEY_PRESSED, group::handleTransformations);

        this.setTitle("Cylinder");
        this.setScene(scene);
    }
}
