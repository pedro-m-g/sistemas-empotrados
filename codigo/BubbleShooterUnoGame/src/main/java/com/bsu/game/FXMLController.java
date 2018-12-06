package com.bsu.game;

import com.bsu.game.items.Cannon;
import com.bsu.game.control.ControlService;
import com.bsu.game.items.Ball;
import com.bsu.game.items.CannonListener;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class FXMLController implements Initializable, CannonListener {

    private final double CANNON_X = 100;
    private final double CANNON_Y = 590;
    
    @FXML
    private AnchorPane root;
    
    private final Cannon cannon;
    private final ControlService control;
    private final List<Ball> balls = new ArrayList<>();
    private Ball next;
    
    public FXMLController() {
        cannon = new Cannon();
        control = new ControlService(cannon);
        cannon.setLayoutX(CANNON_X);
        cannon.setLayoutY(CANNON_Y);
        next = ball();
        next.setLayoutX(CANNON_X - 30);
        next.setLayoutY(CANNON_Y);
        next.getTransforms().add(new Rotate(20, 130, 0));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        root.getChildren().addAll(cannon, next);
        control.start();
        cannon.addListener(this);
    }
    
    private Ball ball() {
        Color[] colors = new Color[] {
            Color.RED, Color.GREEN, Color.TURQUOISE,
            Color.BLUE, Color.VIOLET, Color.PINK,
            Color.YELLOW, Color.ORANGE
        };
        Color color = colors[(int) Math.floor(Math.random() * colors.length)];
        return new Ball(color);
    }

    @Override
    public void rotate(int angle) {
        Rotate r = (Rotate) next.getTransforms().get(0);
        r.setAngle(angle);
    }

    @Override
    public void shoot() {
        Rotate r = (Rotate) next.getTransforms().get(0);
        double angle = r.getAngle();
        double m = Math.tan(angle);
        double x = next.getLayoutX();
        double y = next.getLayoutY();
        double b = y - m*x;
        Path path = new Path(new MoveTo(0, 0), new LineTo(-70, 100));
        PathTransition transition = new PathTransition(Duration.millis(1000), path, next);
        transition.play();
    }
    
}
