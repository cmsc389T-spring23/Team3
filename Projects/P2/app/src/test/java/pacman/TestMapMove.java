package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapMove extends TestCase {

  public void testMapMove() throws FileNotFoundException {
    //Creating A Map
    MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized

    // moving pacman to ghost location
    Ghost ghost1 = frame.addGhost(new Location(2, 1), "red", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman1 = frame.addPacMan(new Location(1,1));

    assertTrue(frame.getMap().move("pacman", new Location(2,1), Map.Type.PACMAN));
    assertTrue(frame.getMap().getLoc(new Location(2,1)).contains(Map.Type.PACMAN));
    assertFalse(frame.getMap().getLoc(new Location(1,1)).contains(Map.Type.PACMAN));

    assertTrue(frame.getMap().move("red", new Location(3,1), Map.Type.GHOST));
    assertTrue(frame.getMap().getLoc(new Location(3,1)).contains(Map.Type.GHOST));
    assertFalse(frame.getMap().getLoc(new Location(2,1)).contains(Map.Type.GHOST));
  }
}
