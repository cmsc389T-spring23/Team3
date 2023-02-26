package pacman;
import junit.framework.*;
import java.io.*;
import java.awt.Color;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized
    
    Ghost ghost = frame.addGhost(new Location(1,2),"name",Color.red);
    PacMan pacman1 = frame.addPacMan(new Location(1, 1));
    
    assertTrue(frame.getMap().attack("name") == true);

  }
}
