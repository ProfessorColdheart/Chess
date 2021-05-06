package com.gui;

public class HumanPlayer extends Player{


    public HumanPlayer(MouseManager mouseManager) {
        super(mouseManager);
    }

    @Override
    public void move() {
        mouseManager.setEnableClick(true);
    }
}
