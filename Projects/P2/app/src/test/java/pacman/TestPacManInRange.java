package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManInRange extends TestCase {

  public void testPacManInRange() throws FileNotFoundException {
     NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized
    
    Ghost ghost = frame.addGhost(new Location(1,2),"name",Color.red);
    PacMan pacman1 = frame.addPacMan(new Location(1, 1));
    
    assertTrue(pacman1.is_ghost_in_range() == true);

  }
}
