package com.bsu.game.control;

import com.bsu.game.command.Command;
import com.bsu.game.command.CommandPalette;
import com.bsu.game.command.RotateCommand;
import com.bsu.game.items.Cannon;

public class ControlService implements Controlled, Runnable {

    private Cannon cannon;
    private CommandPalette palette = new CommandPalette();
    private final ControlReader reader;

    public ControlService(Cannon cannon) {
        this.cannon = cannon;
        commands();
        reader = new ControlReader(this);
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    public void run() {
        reader.start();
    }

    @Override
    public void command(String name, String[] args) {
        Command command = palette.getCommand(name);
        command.run(args);
    }

    private void commands() {
        palette.setCommand("ROTATE", new RotateCommand(cannon));
    }

}