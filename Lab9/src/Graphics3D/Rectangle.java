package Graphics3D;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;

import Custom.SmartGroup;

public class Rectangle extends AbstractShapeStage {
    public Rectangle(int width, int height) { super(width, height); }

    @Override
    public void showStage() {
        Box box = new Box(100, 20, 50);
        SmartGroup group = new SmartGroup();
        group.getChildren().add(box);
        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);
        group.translateXProperty().set(WIDTH / 2);
        group.translateYProperty().set(HEIGHT / 2);
        
        this.addEventHandler(KeyEvent.KEY_PRESSED, group::handleTransformations);

        this.setTitle("Rectangle");
        this.setScene(scene);
        this.show();
    }
}
