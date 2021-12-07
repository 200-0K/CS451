package Texture;

import javafx.scene.image.Image;

public enum Texture {
    WOOD_1("wood1.jpg"),
    NEPTUNE("2k_neptune.jpg"),
    EARTH_NIGHTMAP("8k_earth_nightmap.jpg"),
    SATURN("8k_saturn.jpg"),
    SUN("8k_sun.jpg"),
    VENUS("8k_venus_surface.jpg");

    private Image image;
    private Texture(String imageName) {
        this.image = new Image(Texture.class.getResourceAsStream("../Res/"+imageName));
    }
    public Image getImage() {return image;}
}