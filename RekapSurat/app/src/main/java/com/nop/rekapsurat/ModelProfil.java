package com.nop.rekapsurat;

public class ModelProfil {
    private int image;
    private String name;
    private String email;

    public ModelProfil(int image, String name, String email) {
        this.image = image;
        this.name = name;
        this.email = email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
