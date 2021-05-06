package com.gui;

import com.game.ChessFacade;
import com.game.Coord;
import com.game.figures.Figure;
import javafx.scene.layout.Pane;

import java.util.Collection;

public class BoardManager extends Pane implements HoverListener, ClickListener {
    public static final int SIZE = 50;
    public static final int BOARD_SIZE = 8 * SIZE;
    private SlotView[][] slots;
    private SlotView selectedSlot;
    private ChessFacade chessFacade;
    private Player actualPlayer;
    private Player[] players;

    public BoardManager(ChessFacade chessFacade) {
        ViewsFactory factory = new ViewsFactory();
        slots = factory.prepareBoard();
        this.chessFacade = chessFacade;
    }

    public void startGame() {
        actualPlayer.move();
    }

    @Override
    public void reactToNewSlotHovered(MouseManager mouseManager) {
        SlotView actualHovered = mouseManager.getActualHovered();
        SlotView lastHovered = mouseManager.getLastHovered();
        actualHovered.setHovered(true);
        if (lastHovered != null) {
            lastHovered.setHovered(false);
        }
    }


    @Override
    public void reactToSlotClicked(SlotView slotView) {
        Figure figureOnSlot = slotView.getFigure();
        if (figureOnSlot == null) {
            if (selectedSlot != null) {
                move(slotView);
            }
        } else if (figureOnSlot.getSide().equals(chessFacade.actualPlayer())) {
            select(slotView);
        } else if (selectedSlot != null) {
            attack(slotView);
        } else {
            //niepoprawny ruch
            return;
        }
        //nastepny gracz
        nextPlayer();
    }

    private void nextPlayer() {
        actualPlayer = (actualPlayer == players[0]) ? players[1] : players[0];
    }

    public void attack(SlotView destination) {
        System.out.println("attack");
        Figure figure = selectedSlot.getFigure();

        int columnX = destination.getColumnX();
        int rowY = destination.getRowY();
        //czy figura na pewno moze sie tu ruszyc?
        System.out.println("czytam ruchy dla: " + figure);
        if (chessFacade.getCorrectMovesFor(figure.getX(), figure.getY()).contains(new Coord(columnX, rowY))) {

            chessFacade.attack(figure, columnX, rowY);
            System.out.println("Atak na pole x= " + columnX + ", y = " + rowY);
            selectedSlot.moveTo(destination);
            clearSelection();
            System.out.println(destination);
            System.out.println(chessFacade.getFigureOn(columnX,rowY));
        } else {
            System.out.println("Ruch niemożliwy");
        }
    }

    public void move(SlotView destination) {
        System.out.println("move");
        Figure figure = selectedSlot.getFigure();

        int columnX = destination.getColumnX();
        int rowY = destination.getRowY();
        //czy figura na pewno moze sie tu ruszyc?

        if (chessFacade.getCorrectMovesFor(figure.getX(), figure.getY()).contains(new Coord(columnX, rowY))) {
            chessFacade.move(figure, columnX, rowY);
            System.out.println("Ruch na pole x= " + columnX + ", y = " + rowY);
            selectedSlot.moveTo(destination);
            clearSelection();
        } else {
            System.out.println("Ruch niemożliwy");
        }

    }

    public void select(SlotView slotView) {
        System.out.println("select");
        if (selectedSlot != null && selectedSlot.equals(slotView)) {
            return;
        }

        if (selectedSlot != null) { // stary
            clearSelection();
        }
        selectedSlot = slotView;
        selectedSlot.reactToActionIn(ActionType.SELECTED);

        Figure selectedFigure = slotView.getFigure();

        System.out.println("name: " + selectedFigure.getName());
        Collection<Coord> possibleCoords
                = chessFacade.getCorrectMovesFor(selectedFigure.getX(), selectedFigure.getY());

        for (Coord coord : possibleCoords) {
            SlotView moveSlot = slots[coord.getY()][coord.getX()];
            Figure figureOnMove = moveSlot.getFigure();
            ActionType action;
            if (figureOnMove != null && figureOnMove.getSide() != chessFacade.actualPlayer()) {
                action = ActionType.ATTACK;
            } else {
                action = ActionType.MOVE;
            }
            moveSlot.reactToActionIn(action);
        }
    }

    private void clearSelection() {
        for (SlotView[] slotRow : slots) {
            for (SlotView slot : slotRow) {
                slot.clearAction();
            }
        }
        selectedSlot = null;
    }

    public SlotView[][] getSlots() {
        return slots;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
        actualPlayer = players[0];
    }
}
