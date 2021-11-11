import com.tus.model.Game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GamesArrayList  extends UnicastRemoteObject implements IArrayList{

    private ArrayList<Game> games;
    public GamesArrayList() throws RemoteException {
        super();
    }
    @Override
    public ArrayList<Game> getGames() throws RemoteException {
        return games;
    }

    @Override
    public void setGames(ArrayList<Game> games) throws RemoteException {
        this.games = games;
    }
}
