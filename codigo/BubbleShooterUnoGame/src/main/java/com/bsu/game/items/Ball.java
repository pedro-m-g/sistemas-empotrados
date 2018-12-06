/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsu.game.items;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author pedro
 */
public class Ball extends Parent {
    
    private final Circle view;
    
    public Ball(Color color) {
        view = new Circle(15, color);
        getChildren().add(view);
    }
    
}
