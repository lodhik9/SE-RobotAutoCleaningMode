import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObservable extends Remote
{
    public void addObserver(Observer o) throws RemoteException;

    public void deleteObserver(Observer o) throws RemoteException;

    public boolean hasChanged() throws RemoteException;

    public int countObservers() throws RemoteException;
    
    //public void goToDock(int position) throws RemoteException;
    
    

    // public void deleteObservers() throws RemoteException;

    // public void notifyObservers() throws RemoteException;

    // public void notifyObservers(Object o) throws RemoteException;

}
