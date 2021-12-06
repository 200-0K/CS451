package Graphics3D;
import Custom.SmartGroup;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Sphere extends AbstractShapeStage {
    public Sphere(int width, int height) { super(width, height); }

    @Override
    public void showStage() {
        javafx.scene.shape.Sphere sphere = new javafx.scene.shape.Sphere(50);
        SmartGroup group = new SmartGroup();
        group.getChildren().add(sphere);
        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.BEIGE);
        scene.setCamera(camera);
        sphere.translateXProperty().set(WIDTH / 2);
        sphere.translateYProperty().set(HEIGHT / 2);
        
        this.addEventHandler(KeyEvent.KEY_PRESSED, group::handleTransformations);

        this.setTitle("Sphere");
        this.setScene(scene);
        this.show();
    }
}
