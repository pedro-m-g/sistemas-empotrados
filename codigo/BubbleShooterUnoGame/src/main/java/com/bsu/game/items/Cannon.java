/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsu.game.items;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author pedro
 */
public class Cannon extends Parent {
    
    private final String src = "/icons/cannon_sprite.png";
    private final ImageView view = new ImageView(new Image(getClass().getResourceAsStream(src)));
    
    private final int BASE_ANGLE = 180;
    
    public Cannon() {
        getChildren().add(view);
        rotate(0);
    }
    
    public void rotate(int angle) {
        view.setRotate(angle);
    }
    
}
