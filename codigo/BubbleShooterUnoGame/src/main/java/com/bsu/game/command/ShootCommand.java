/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsu.game.command;

import com.bsu.game.items.Cannon;

/**
 *
 * @author pedro
 */
public class ShootCommand implements Command {

    private Cannon cannon;
    
    public ShootCommand(Cannon cannon) {
        this.cannon = cannon;
    }
    
    @Override
    public void run(String[] args) {
        cannon.shoot();
    }
    
}
