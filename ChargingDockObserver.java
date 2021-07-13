import java.rmi.RemoteException;
import java.rmi.server.*;

/**
 * Write a description of class ChargingDockObserver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChargingDockObserver extends UnicastRemoteObject implements Observer 
{
    // instance variables - replace the example below with your own
    private int currentBattery;
    private Map chargingMap;
    private IObservable con = null;
    
    public ChargingDockObserver (IObservable ov) throws RemoteException
    {
        this.con = ov;
        con.addObserver(this);
        System.out.println("Charging Dock created.");
    }

    
    /**
     * Constructor for objects of class ChargingDockObserver
     */
    public ChargingDockObserver() throws RemoteException
    {
        // initialise instance variables
        currentBattery = 0;
        chargingMap = new Map(2,3,4);
       //con = new Controller();
    }
    
    void setBattery(int b)
    {
        this.currentBattery = b;
    }
    
    int getBattery()
    {
        return this.currentBattery;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    @Override
    public void update(IObservable obs, Object news) throws RemoteException {
        this.setBattery((int) news);
    } 
    
    public void charging() {
        //this.con.goToDock(chargingMap.getter())  ;
        System.out.print("Charging has started ");
    } 
}
