package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.*;

public class TestGhostMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();
    Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red);
    ArrayList<Location> moves = ghost.get_valid_moves();
    assertTrue(ghost.move());
    assertTrue(moves.contains(ghost.myLoc));
  }
}
