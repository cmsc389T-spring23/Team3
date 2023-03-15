package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;


public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens Initialized

    PacMan pacman1 = frame.addPacMan(new Location(1, 1));
    int cookieBefore = frame.getMap().getCookies();
    frame.getMap().eatCookie("pacman");
    int cookieAfter = frame.getMap().getCookies();
    assertNotSame(cookieBefore, cookieAfter);

    return;
  }
}
