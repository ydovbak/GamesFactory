import com.tus.model.Game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IArrayList extends Remote {
    public ArrayList<Game> getGames()  throws RemoteException;
    public void setGames(ArrayList<Game> games) throws RemoteException;
}
