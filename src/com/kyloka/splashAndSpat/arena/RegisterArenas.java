package com.kyloka.splashAndSpat.arena;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.objects.Arena;
import com.kyloka.splashAndSpat.objects.PlayerUser;

import java.io.*;

/**
 * Created by Matthew on 10/22/2016.
 */
public class RegisterArenas {


    private static Arena arena1 = new Arena("Alpha");
    private static Arena arena2 = new Arena("Delta");
    private static Arena arena3 = new Arena("Phi");
    private static Arena arena4 = new Arena("Omega");
    private static File configFile = new File(Main.getInstance().getDataFolder(),"data.yml");

    private static PlayerUser playerUser1 = new PlayerUser();
    private static PlayerUser playerUser2 = new PlayerUser();
    private static PlayerUser playerUser3 = new PlayerUser();
    private static PlayerUser playerUser4 = new PlayerUser();
    public RegisterArenas(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(configFile));
            boolean empty = reader.readLine() == null;
            arena1.setName("Alpha");
            if (empty){
                arena1.defaultConfig();
            }
            arena1.registerEachLocation();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        getArena1().setPlayerUser(getPlayerUser1());
        getArena2().setPlayerUser(getPlayerUser2());
        getArena3().setPlayerUser(getPlayerUser3());
        getArena4().setPlayerUser(getPlayerUser4());

        getArena1().setGameState(GameState.WAITING);
        getArena2().setGameState(GameState.WAITING);
        getArena3().setGameState(GameState.WAITING);
        getArena4().setGameState(GameState.WAITING);
    }
    public static Arena getArena1(){
        return arena1;
    }
    public static Arena getArena2(){
        return arena2;
    }
    public static Arena getArena3(){
        return arena3;
    }
    public static Arena getArena4(){
        return arena4;
    }
    public static PlayerUser getPlayerUser1(){
        return playerUser1;
    }
    public static PlayerUser getPlayerUser2(){
        return playerUser2;
    }
    public static PlayerUser getPlayerUser3(){
        return playerUser3;
    }
    public static PlayerUser getPlayerUser4(){
        return playerUser4;
    }

}
