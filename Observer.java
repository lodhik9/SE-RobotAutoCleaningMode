import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * Write a description of interface Observer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Observer 
{
    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  y a sample parameter for a method
     * @return   the result produced by sampleMethod
     */
    public void update(IObservable o, Object arg) throws RemoteException;

}
