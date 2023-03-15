package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.*;
import pacman.Map.Type;

public class TestGhostValidMoves extends TestCase {

  public void testGhostValidMoves() throws FileNotFoundException {
    //Creating A Map
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized

    Ghost ghost1 = frame.addGhost(new Location(2, 2), "red", Color.red); //Creates a red ghost named "name" at location x,y
    ArrayList<Location> moves1 = ghost1.get_valid_moves();
    assertTrue(moves1.contains(new Location(1,2)));
    assertTrue(moves1.contains(new Location(2,1)));
    assertFalse(moves1.contains(new Location(1,0)));
    assertFalse(moves1.contains(new Location(0,1)));

    Ghost ghost2 = frame.addGhost(new Location(1, 11), "orange", Color.orange); //Creates a red ghost named "name" at location x,y
    ArrayList<Location> moves2 = ghost2.get_valid_moves();
    assertTrue(moves2.contains(new Location(1,10)));
    assertFalse(moves2.contains(new Location(0,11)));
    assertFalse(moves2.contains(new Location(1,12)));
    assertFalse(moves2.contains(new Location(2,11)));
  }
}
