package com.kyloka.splashAndSpat.arena;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.objects.Arena;
import com.kyloka.splashAndSpat.objects.PlayerUser;

import java.io.*;

/**
 * Created by Matthew on 10/22/2016.
 */
public class RegisterArenas {


    private Arena arena1 = new Arena("Alpha");
    private Arena arena2 = new Arena("Delta");
    private Arena arena3 = new Arena("Phi");
    private Arena arena4 = new Arena("Omega");
    private File configFile = new File(Main.getInstance().getDataFolder(),"data.yml");

    private PlayerUser playerUser1 = new PlayerUser();
    private PlayerUser playerUser2 = new PlayerUser();
    private PlayerUser playerUser3 = new PlayerUser();
    private PlayerUser playerUser4 = new PlayerUser();
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


    }
    public Arena getArena1(){
        return arena1;
    }
    public Arena getArena2(){
        return arena2;
    }
    public Arena getArena3(){
        return arena3;
    }
    public Arena getArena4(){
        return arena4;
    }
    public PlayerUser getPlayerUser1(){
        return playerUser1;
    }
    public PlayerUser getPlayerUser2(){
        return playerUser2;
    }
    public PlayerUser getPlayerUser3(){
        return playerUser3;
    }
    public PlayerUser getPlayerUser4(){
        return playerUser4;
    }

}
