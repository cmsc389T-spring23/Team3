package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.HashSet;
import pacman.Map.Type;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();
    HashSet<Type> test = new HashSet<Type>();
    test.add(Map.Type.WALL);
    assertEquals(map.getLoc(new Location (2,4)), test);
    test.remove(Map.Type.WALL);
    test.add(Map.Type.COOKIE);
    frame.addPacMan(new Location(1, 1));
    map = frame.getMap();
    test.add(Map.Type.PACMAN);
    assertEquals(map.getLoc(new Location (1,1)), test);
    return;
  }
}
