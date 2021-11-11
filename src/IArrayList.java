import com.tus.model.Game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * To enable binding an ArrayList through RMI, we need to implement a Remote version of ArrayList.
 * The interface defines methods to get and set the ArrayList.
 */
public interface IArrayList extends Remote {
    public ArrayList<Game> getGames()  throws RemoteException;
    public void setGames(ArrayList<Game> games) throws RemoteException;
}
