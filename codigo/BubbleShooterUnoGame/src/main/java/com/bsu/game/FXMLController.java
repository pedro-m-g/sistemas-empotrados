package com.bsu.game;

import com.bsu.game.items.Cannon;
import com.bsu.game.control.ControlService;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class FXMLController implements Initializable {

    private final double CANNON_X = 120;
    private final double CANNON_Y = 600;
    
    @FXML
    private AnchorPane root;
    
    private final Cannon cannon;
    private final ControlService control;
    
    public FXMLController() {
        cannon = new Cannon();
        control = new ControlService(cannon);
        cannon.setLayoutX(CANNON_X);
        cannon.setLayoutY(CANNON_Y);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        root.getChildren().add(cannon);
        control.start();
    }
    
}
