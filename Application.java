import java.io.IOException;
import java.util.*;
/**
 * Write a description of class Application here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Application
{
    public static void main()
    {
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Type 'yes' to start the robot or 'no' not to");
        String answer = scanner.next();
        
        try
       {
        RobotClient client;
        
        if(answer.equals("yes"))
        {
            client = new RobotClient();
            
            while(answer.equals("yes"))
            {   
              System.out.println("\n Select from the menu:  'AutoMode', 'Pause', 'ReturnInital'");
                String choice = scanner.next();
                if(choice.equals("AutoMode"))
                {
                    client.startCleaning();
                }
                
                else if(choice.equals("exit"))
                {
                    answer = "n";
                }
                
                else
                {
                    System.out.println("Invalid Input");
                }
                
            }
        }
                      
        }
        catch(Exception e)
        {
           System.out.println("");
        }
       
        
          
        
        
      // OBSERVER PATTERN
      //Controller controllerObservable = new Controller();
      //ChargingDockObserver observer1 = new ChargingDockObserver();
      //NotificationObserver observer2 = new NotificationObserver();

      //controllerObservable.addObserver(observer1);
      //controllerObservable.setBattery(4);
      //System.out.print(observer1.getBattery()+"\n");
        
      // Strategy PATTERN
      
      
      /*Context context = new Context(new DryCleaning());		
      System.out.println("Dry cleaning: " + context.executeStrategy());

      context = new Context(new WetCleaning());		
      System.out.println("Wet Cleaning: " + context.executeStrategy());

      context = new Context(new ReturnInitial());		
      System.out.println("Return Inital: " + context.executeStrategy());
       
        try {
            MyLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        
        */
        
        //controllerObservable.doSomeThingAndLog();
    
    }
}

