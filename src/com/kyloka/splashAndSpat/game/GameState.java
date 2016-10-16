package com.kyloka.splashAndSpat.game;

/**
 * Created by Matthew on 10/16/2016.
 */
public class GameState {

    private GameList state;
    public void setState(GameList state){
        this.state = state;
    }
    public boolean isState(GameList state){
        return this.state == state;
    }
    public GameList getWaiting(){
        return state;
    }
}
