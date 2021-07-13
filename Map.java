import java.rmi.RemoteException;


/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int z;

    /**
     * Constructor for objects of class Map
     */
    public Map(int x, int y, int z)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getter() 
    {
        // put your code here
        return x + y + z;
    }
}
