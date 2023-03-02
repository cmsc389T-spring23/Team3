package pacman;
import java.io.*;
import junit.framework.*;

import java.awt.Color;

public class TestPacManConsume extends TestCase {

  public void testPacManConsume() throws FileNotFoundException {
    //Creating A Map
    MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
    

    //Creating Players
    PacMan pacman = frame.addPacMan(new Location(1, 1)); //Creates PacMan at location x, y
    assertNotSame(pacman.consume(), null);
    
    return;

  }
}
