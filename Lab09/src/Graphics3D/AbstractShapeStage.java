package Graphics3D;

import javafx.stage.Stage;

public abstract class AbstractShapeStage extends Stage {
    protected final int WIDTH;
    protected final int HEIGHT;

    protected AbstractShapeStage(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
    }
    
    abstract public void showStage();
}
