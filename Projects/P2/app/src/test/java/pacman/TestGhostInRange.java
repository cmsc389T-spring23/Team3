package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostInRange extends TestCase {

  public void testGhostInRange() throws FileNotFoundException {
  NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized
    
    Ghost ghost = frame.addGhost(new Location(1,2),"name",Color.red);
    PacMan pacman1 = frame.addPacMan(new Location(1, 1));
    
    assertTrue(ghost.is_pacman_in_range() == true);

  }
}
