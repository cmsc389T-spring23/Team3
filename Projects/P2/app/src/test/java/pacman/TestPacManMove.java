package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.*;
import pacman.Map.Type;

public class TestPacManMove extends TestCase {

  public void testPacManMove() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();
    PacMan pacman = frame.addPacMan(new Location(1, 1));
    ArrayList<Location> moves = pacman.get_valid_moves();
    assertTrue(pacman.move());
    assertTrue(moves.contains(pacman.myLoc));
    return;
  }
}
