import Graphics3D.AbstractShapeStage;
import Graphics3D.Cylinder;
import Graphics3D.Rectangle;
import Graphics3D.Sphere;
import Texture.PhongMaterialBuilder;
import Texture.Texture;
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

        Texture[] textures = Texture.values();
        for (AbstractShapeStage shape : shapes) {
            int randomIndex = (int) Math.floor(Math.random() * textures.length);
            shape.setMaterial(
                new PhongMaterialBuilder()
                .diffuseMap(textures[randomIndex])
                .specularMap(textures[randomIndex])
                .build()
            );
            shape.showStage();
        }
    }
}
