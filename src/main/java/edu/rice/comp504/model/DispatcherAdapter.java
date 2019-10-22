package edu.rice.comp504.model;

import java.beans.PropertyChangeSupport;
import java.io.IOException;

public class DispatcherAdapter {

    Game game;

    /**
     * Constructor.
     */
    public DispatcherAdapter() {

    }

    public Game loadGame() {
        game = new Game();
        game.loadLevelOne();
        return game;
    }

    public void startGame() {

    }

    public Game updateGame() {
        game.update();
        return game;
    }

    public Game movePacman(int direction) {
        game.pacmanMove(direction);
        return game;
    }
}
