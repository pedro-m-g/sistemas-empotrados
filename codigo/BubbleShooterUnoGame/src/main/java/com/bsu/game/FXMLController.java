package com.bsu.game;

import com.bsu.game.items.Cannon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
    
    private Stage stage;
    
    @FXML
    private AnchorPane root;
    
    private final Cannon cannon;
    
    public FXMLController() {
        cannon = new Cannon();
        AnchorPane.setBottomAnchor(cannon, 0.0);
        AnchorPane.setLeftAnchor(cannon, 120.0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        root.getChildren().add(cannon);
    }
    
}
