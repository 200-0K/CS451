package Texture;

import javafx.scene.paint.PhongMaterial;

public class PhongMaterialBuilder {
    private PhongMaterial material;
    
    public PhongMaterialBuilder() {
        material = new PhongMaterial();
    }

    public PhongMaterialBuilder diffuseMap(Texture texture) {
        material.setDiffuseMap(texture.getImage());
        return this;
    }

    public PhongMaterialBuilder specularMap(Texture texture) {
        material.setSpecularMap(texture.getImage());
        return this;
    }

    public PhongMaterial build() {
        return material;
    }
}
