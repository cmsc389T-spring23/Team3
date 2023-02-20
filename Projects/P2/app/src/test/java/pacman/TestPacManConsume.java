package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManConsume extends TestCase {

  public void testPacManConsume() throws FileNotFoundException {
    //Creating A Map
    Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
    

    //Creating Players
    PacMan pacman = frame.addPacMan(new Location(2, 2)); //Creates PacMan at location x, y
    if(pacman.consume() == null){
      
    }
    frame.add("cookie", new Location(2, 2), null, Map.Type.COOKIE);
    if(pacman.consume() != null){
      
    }
    
    return;

  }
}
