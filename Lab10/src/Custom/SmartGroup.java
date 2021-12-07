package Custom;

import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public class SmartGroup extends Group {
    Rotate r;
    Transform t = new Rotate();

    public void rotateByX(int ang) {
        r = new Rotate(ang, Rotate.X_AXIS);
        t = t.createConcatenation(r);
        this.getTransforms().clear();
        this.getTransforms().addAll(t);
    }

    public void rotateByY(int ang) {
        r = new Rotate(ang, Rotate.Y_AXIS);
        t = t.createConcatenation(r);
        this.getTransforms().clear();
        this.getTransforms().addAll(t);
    }

    public void handleTransformations(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                this.translateZProperty().set(this.getTranslateZ() + 50);
                break;
            case S:
                this.translateZProperty().set(this.getTranslateZ() - 50);
                break;
            case Q:
                this.rotateByX(10);
                break;
            case E:
                this.rotateByX(-10);
                break;
            case P:
                this.rotateByY(10);
                break;
            case L:
                this.rotateByY(-10);
                break;
        }
    }
}