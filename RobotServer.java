import java.rmi.Naming;
import java.net.*;
import java.rmi.registry.LocateRegistry;
/**
 * server class that listens for a client and receives requests.
 */
public class RobotServer {
    public static void main(String [] args) throws Exception {
        IRobot robot = new Controller();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("Robot", robot);
        System.out.println("Listening for clients");
    }
}
