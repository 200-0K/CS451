package Graphics3D;

import Custom.SmartGroup;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Cylinder extends AbstractShapeStage {
    public Cylinder(int width, int height) { super(width, height); }

    @Override
    public void showStage() {
        javafx.scene.shape.Cylinder cylinder = new javafx.scene.shape.Cylinder(50, 200);
        SmartGroup group = new SmartGroup();
        group.getChildren().add(cylinder);
        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.BURLYWOOD);
        scene.setCamera(camera);
        cylinder.translateXProperty().set(WIDTH / 2);
        cylinder.translateYProperty().set(HEIGHT / 2);

        this.addEventHandler(KeyEvent.KEY_PRESSED, group::handleTransformations);

        this.setTitle("Cylinder");
        this.setScene(scene);
        this.show();
    }
}
