package game;

import java.io.*;

public class GameManager {

    public void saveGame(Game g) throws IOException {
        FileOutputStream fos = new FileOutputStream("saveGames/lastGame.sav");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(g);
        oos.close();
        fos.close();
    }

    public Game loadGame() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("saveGames/lastGame.sav");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Game obj = (Game) ois.readObject();
        ois.close();
        fis.close();
        return obj;
    }
    
}
