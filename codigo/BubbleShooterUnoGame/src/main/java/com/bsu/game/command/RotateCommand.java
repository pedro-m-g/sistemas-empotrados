package com.bsu.game.command;

import com.bsu.game.items.Cannon;
import javafx.application.Platform;

public class RotateCommand implements Command {

    private Cannon cannon;

    public RotateCommand(Cannon cannon) {
        this.cannon = cannon;
    }

    public void run(String[] args) {
        final int angle = Integer.parseInt(args[0]);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                cannon.rotate(angle);
            }
        });
    }

}
