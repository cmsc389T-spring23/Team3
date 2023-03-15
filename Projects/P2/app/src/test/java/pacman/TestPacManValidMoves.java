package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.*;
import pacman.Map.Type;

public class TestPacManValidMoves extends TestCase {

  public void testPacManValidMoves() throws FileNotFoundException {
    //Creating A Map
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized

    PacMan pacman1 = frame.addPacMan(new Location(1, 1)); //Pacman at location 2,2
    ArrayList<Location> moves1 = pacman1.get_valid_moves();
    assertTrue(moves1.contains(new Location(1,2)));
    assertTrue(moves1.contains(new Location(2,1)));
    assertFalse(moves1.contains(new Location(1,0)));
    assertFalse(moves1.contains(new Location(0,1)));
    Ghost ghost1 = frame.addGhost(new Location(1, 2), "red", Color.red); //Creates a red ghost named "name" at location x,y
    ArrayList<Location> moves2 = pacman1.get_valid_moves();
    assertTrue(moves2.contains(new Location(1,2)));
    assertTrue(moves2.contains(new Location(2,1)));
    assertFalse(moves2.contains(new Location(1,0)));
    assertFalse(moves2.contains(new Location(0,1)));
  }
}
