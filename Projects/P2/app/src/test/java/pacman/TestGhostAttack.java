package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostAttack extends TestCase {

  public void testGhostAttack() throws FileNotFoundException {
	  NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized

	    PacMan pacman1 = frame.addPacMan(new Location(12, 12));
	    Ghost ghost1 = frame.addGhost(new Location(1, 1), "Inky" , Color.red);
	    assertEquals(ghost1.attack(), false);
	    Ghost ghost2 = frame.addGhost(new Location(13, 12), "Clyde" , Color.red);
	    assertEquals(ghost2.attack(), true);
	  
	  return;
  }
}
