package com.kyloka.splashAndSpat.game;

/**
 * Created by Matthew on 10/16/2016.
 */
public enum GameState {
    WAITING,
    STARTED,
    END
    ;
    private GameState(){

    }
    private GameState state;
    public void setState(GameState state){
        this.state = state;
    }
    public boolean isState(GameState state){
        return this.state == state;
    }
    public GameState getWaiting(){
        return state;
    }
}
