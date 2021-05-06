package com.gui;

public abstract class Player {
    protected MouseManager mouseManager;

    public Player(MouseManager mouseManager) {
        this.mouseManager = mouseManager;
    }

    public abstract void move();

    //w przypadku prawdziwego gracza:
    //umozliwic mu klikanie

    //w przypadku komputera:
    //zablokować klikanie
    //wywola na MouseManagerze 2 akcje:
    //  wybranie figury przez  reactToClickCoords( int x,int y )
    //  przemieszczenie przez  reactToClickCoords( int x,int y )

}
