import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Vector;
import java.rmi.RemoteException;
import java.rmi.server.*;

/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Controller  extends UnicastRemoteObject implements IObservable, BMS, IRobot  {
    private int currentBattery;
    private List<Observer> observers = new ArrayList<>();
    private int cleaningStatus;
    private String wetDry;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private String tempLog;
    private Sensors sensor;
    private boolean changed = false; 
 
    public Controller( ) throws RemoteException{
      this.currentBattery = 0;
      this.cleaningStatus = 0;
      this.wetDry = "";
      this.tempLog="";
      this.sensor = new Sensors();
   }
   
    public Controller(int currentBattery,int cleaningStatus, String wetDry ) throws RemoteException{
      this.currentBattery = currentBattery;
      this.cleaningStatus = cleaningStatus;
      this.wetDry = wetDry;
   }
   

   @Override
   public int checkBattery()
   {
       return currentBattery;
   }
   
   @Override
    public synchronized void addObserver(Observer observer) throws RemoteException {
        this.observers.add(observer);
    }

    @Override
    public synchronized void deleteObserver(Observer observer) throws RemoteException {
        this.observers.remove(observer);
    }
    
    public void setBattery(int battery) {
        this.currentBattery = battery;
        notifyObservers(null);
    }

    public void notifyObservers(Object arg) { 

        Object[] arrLocal; 

        synchronized (this) {
            if (!changed) 
                return; 
            arrLocal = observers.toArray(); 
            clearChanged(); 
        } 

        for (int i = arrLocal.length-1; i>=0; i--)
            try{
                ((Observer)arrLocal[i]).update(this, arg); 
            }
            catch(RemoteException e){
                System.out.println("Failure in updating Object "
                    + ((Observer)arrLocal[i]));
            }
    } 

    
    
    public void goToDock()  
    {
        // put your code here
        this.currentBattery = 100;
    }
    
    public void dryAndWetCleaning() throws RemoteException 
    {
        // Strategy PATTERN
      Context context = new Context(new DryCleaning());		
      System.out.println("Dry cleaning: " + context.executeStrategy());
       
        try {
            MyLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
    }
    
    @Override
    public IStatus cleaning(String dryWet)
    {
        IStatus status = new IStatus();
        this.wetDry = dryWet;
        
        if(currentBattery > 10)
        {
            if(wetDry.equals("Dry"))
            {
              Context context = new Context(new DryCleaning());
              tempLog = context.executeStrategy();
              status.setStatus("Robot is dry cleaning");
              
            }
            else if(wetDry.equals("Wet"))
            {
              Context context = new Context(new WetCleaning());
              tempLog = context.executeStrategy();  
              status.setStatus("Robot is wet cleaning");
             
            }
            else 
            {
            Context context = new Context(new ReturnInitial());
            tempLog = context.executeStrategy();
            status.setStatus("Robot is returning inital");
            
            }
            this.currentBattery -= 10;
        }
        else
        {
            goToDock();
            status.setStatus("Robot is charging");
            
        }
        return status;
    }
    
     public void doSomeThingAndLog() {
         
         if(tempLog.equals("Dry cleaning algorithm has been choosen"))
         {
             LOGGER.setLevel(Level.SEVERE);
             LOGGER.severe("Dry cleaning has been done"); //
         }
         
         else if(tempLog.equals("Wet cleaning algorithm has been choosen"))
         {
             LOGGER.setLevel(Level.SEVERE);
             LOGGER.severe("Wet cleaning has been done"); //
         }
         
         else
         {
             LOGGER.setLevel(Level.INFO);
             LOGGER.info("Returned to inital position"); //
         }        
    }
    
    public synchronized int countObservers() throws RemoteException { 
        return observers.size(); 
    }
    
    protected synchronized void setChanged() { 
        changed = true; 
    } 

    protected synchronized void clearChanged() { 
        changed = false; 
    } 

        public synchronized boolean hasChanged() throws RemoteException { 
            return changed; 
    } 

}


