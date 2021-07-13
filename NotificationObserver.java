import java.rmi.RemoteException;
import java.rmi.server.*;
/**
 * Write a description of class NotificationObserver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NotificationObserver extends UnicastRemoteObject implements Observer 
{
    // instance variables - replace the example below with your own
    private int currentBattery;
    private int distanceToCover;
    private IObservable con = null;
    
    public NotificationObserver (IObservable ov) throws RemoteException
    {
        this.con = ov;
        con.addObserver(this);
        System.out.println("Charging Dock created.");
    }


    /**
     * Constructor for objects of class NotificationObserver
     */
    public NotificationObserver() throws RemoteException
    {
        // initialise instance variables
        currentBattery = 0;
        distanceToCover = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    void setBattery(int b)
    {
        this.currentBattery = b;
    }
    
   @Override
    public void update(IObservable obs, Object news) throws RemoteException {
        this.setBattery((int) news);        
    } 
    
     public void notifyApp()
    {
        // put your code here
        this.distanceToCover = distanceToCover * currentBattery;
        System.out.print("current Battery " + currentBattery + "distance To Cover " + distanceToCover);
    }
}
