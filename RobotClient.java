import java.rmi.*;
/**
 * The client side class that makes a call to connect to the server side.
 */
public class RobotClient
{
   
   public void startCleaning()
   
   {   
       try
       {
           IRobot robot = (IRobot) Naming.lookup("rmi://127.0.0.1/Robot") ;
           System.out.print("response from the server: " + robot.cleaning("dry").getStatus() + "\n");    
       }
       catch(Exception e)
       {
           System.out.println("Something went wrong in cleaning()");
       }
       
       
   }
   
   
   
   
}
