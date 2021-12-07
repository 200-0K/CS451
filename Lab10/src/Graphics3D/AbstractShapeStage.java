package Graphics3D;

import javafx.scene.paint.Material;
import javafx.scene.shape.Shape3D;
import javafx.stage.Stage;

public abstract class AbstractShapeStage extends Stage {
    protected Shape3D shape;
    
    public void showStage() {
        this.show();
    };

    public void setMaterial(Material material) {
        shape.setMaterial(material);
    };
}
