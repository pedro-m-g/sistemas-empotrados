/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsu.game.items;

import java.util.ArrayList;
import java.util.List;
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
    private final Rectangle view = new Rectangle(60, 30, Color.DIMGRAY);

    private int angle = 20;
    private final Rotate rotate = new Rotate();
    private final List<CannonListener> listeners = new ArrayList<>();
    
    public Cannon() {
        view.setLayoutY(-20);
        base.setLayoutX(100);
        rotate.setPivotX(100);
        rotate.setPivotY(15);
        rotate.setAxis(Rotate.Z_AXIS);
        view.getTransforms().addAll(rotate);
        getChildren().addAll(view, base);
        rotate(angle);
    }
    
    public void addListener(CannonListener listener) {
        listeners.add(listener);
    }
    
    public final void rotate(int angle) {
        System.out.println("ROTATE " + angle);
        this.angle = angle;
        rotate.setAngle(angle);
        for (CannonListener listener : listeners) {
            listener.rotate(angle);
        }
    }
    
    public final void shoot() {
        System.out.println("SHOOT");
        for (CannonListener listener : listeners) {
            listener.shoot();
        }
    }
    
}
