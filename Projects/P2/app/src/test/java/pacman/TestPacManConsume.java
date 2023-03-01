package pacman;
import java.io.*;
import junit.framework.*;
import pacman.frames.CookieComponent;

import java.awt.Color;

public class TestPacManConsume extends TestCase {

  public void testPacManConsume() throws FileNotFoundException {
    //Creating A Map
    Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
    

    //Creating Players
    PacMan pacman = frame.addPacMan(new Location(2, 2)); //Creates PacMan at location x, y
    assertEquals(pacman.consume(), null);
    frame.add("cookie", new Location(2, 2), new CookieComponent(2, 2, 20), Map.Type.COOKIE);
    assertNotSame(pacman.consume(), null);
    
    return;

  }
}
