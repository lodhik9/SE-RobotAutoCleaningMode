
/**
 * The class IStatus gives the status of the robot
 *
 * @author (Muhammad Khan Lodhi)
 * @version (17/06/2021)
 */
public class IStatus
{
    // instance variables - replace the example below with your own
    private String status;

    /**
     * Constructor for objects of class IStatus
     */
    public IStatus()
    {
        // initialise instance variables
        status = "";
    }

    /**
     */
    public void setStatus(String y)
    {
        // put your code here
        status = y;
    }
    
    /**
     */
    public String getStatus()
    {
        // put your code here
        return "The status of Robot is : " + status;
    }
}
