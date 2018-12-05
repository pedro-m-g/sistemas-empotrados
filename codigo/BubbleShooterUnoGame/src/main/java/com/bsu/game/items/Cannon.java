/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsu.game.items;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

/**
 *
 * @author pedro
 */
public class Cannon extends Parent {
    
    private final Circle base = new Circle(50, Color.DIMGRAY);
    private final Rectangle view = new Rectangle(30, 60, Color.DIMGRAY);

    private int angle = 20;
    private final Rotate rotate = new Rotate(angle);
    
    public Cannon() {
        base.setLayoutX(60);
        rotate.setPivotX(60);
        rotate.setPivotY(15);
        rotate.setAxis(Rotate.Z_AXIS);
        view.getTransforms().addAll(rotate, new Rotate(90));
        getChildren().addAll(view, base);
    }
    
    public final void rotate(int angle) {
        System.out.println("ROTATE " + angle);
        this.angle = angle;
        rotate.setAngle(angle);
    }
    
}
