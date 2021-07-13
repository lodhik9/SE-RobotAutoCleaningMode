import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 */
public interface IRobot extends Remote
{
    IStatus cleaning(String deryWet) throws RemoteException;
}
