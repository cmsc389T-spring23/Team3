package pacman;

import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

  public enum Type {
    EMPTY,
    PACMAN,
    GHOST,
    WALL,
    COOKIE
  }

  private HashMap<Location, HashSet<Type>> field;
  private boolean gameOver;
  private int dim;

  private HashMap<String, Location> locations;
  private HashMap<String, JComponent> components;
  private HashSet<Type> emptySet;
  private HashSet<Type> wallSet;

  private int cookies = 0;

  public Map(int dim) {
    gameOver = false;
    locations = new HashMap<String, Location>();
    components = new HashMap<String, JComponent>();
    field = new HashMap<Location, HashSet<Type>>();

    emptySet = new HashSet<Type>();
    wallSet = new HashSet<Type>();
    emptySet.add(Type.EMPTY);
    wallSet.add(Type.WALL);
    this.dim = dim;
  }

  public void add(String name, Location loc, JComponent comp, Type type) {
    locations.put(name, loc);
    components.put(name, comp);
    if (!field.containsKey(loc))
      field.put(loc, new HashSet<Type>());
    field.get(loc).add(type);
  }

  public int getCookies() {
    return cookies;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public boolean move(String name, Location loc, Type type) {
    // update locations, components, and field
    // use the setLocation method for the component to move it to the new location
    if (getLoc(new Location(loc.x, loc.y)).contains(Map.Type.WALL)) {
      return false;
    }
    if (type == Type.PACMAN) {
      Location old = locations.get(name); // get old location
      field.get(old).remove(Type.PACMAN);  // remove pacman from old location
      field.get(loc).add(Type.PACMAN);    // add pacman to new location
      locations.put(name, loc);           // set new location
      components.get(name).setLocation(loc.x, loc.y);   // update component
      return true;
    }
    if (type == Type.GHOST) {
      Location old = locations.get(name); // get old location
      field.get(old).remove(Type.GHOST); // remove ghost from old location
      field.get(loc).add(Type.GHOST); // add ghost to new location
      locations.put(name, loc); // set new location
      components.get(name).setLocation(loc.x, loc.y); // update component
      return true;
    }
    return false;
  }

  public HashSet<Type> getLoc(Location loc) {

    if (loc.x < 0 || loc.x >= dim
        || loc.y < 0 || loc.y >= dim) {
      return wallSet;
    }


    if (field.containsKey(loc)) {
      return field.get(loc);
    }
    // wallSet and emptySet will help you write this method
    return emptySet;
  }

  public boolean attack(String Name) {
    Location loc = locations.get(Name);
    int x = loc.x;
    int y = loc.y;

    if (getLoc(new Location(x,y)).contains(Map.Type.GHOST)){
      this.gameOver = true;
    }
    if (getLoc(new Location(x - 1, y)).contains(Map.Type.GHOST)) {
      this.gameOver = true;
    }
    if (getLoc(new Location(x + 1, y + 1)).contains(Map.Type.GHOST)) {
      this.gameOver = true;
    }
    if (getLoc(new Location(x - 1, y - 1)).contains(Map.Type.GHOST)) {
      this.gameOver = true;
    }
    if (getLoc(new Location(x, y + 1)).contains(Map.Type.GHOST)) {
      this.gameOver = true;
    }
    if (getLoc(new Location(x, y - 1)).contains(Map.Type.GHOST)) {
      this.gameOver = true;
    }
    if (getLoc(new Location(x - 1, y + 1)).contains(Map.Type.GHOST)) {
      this.gameOver = true;
    }
    if (getLoc(new Location(x + 1, y - 1)).contains(Map.Type.GHOST)) {
      this.gameOver = true;
    }
    return true;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1

    Location pacManLocation = locations.get(name); // get pacman's location



    if (field.get(pacManLocation).contains(Map.Type.COOKIE)) { // check if there is a cookie where pacman is located
      String cookieID = "tok_x" + pacManLocation.x + "_y" + pacManLocation.y; // create the cookie ID string
      JComponent returnCookie = components.get(cookieID); // save the JComponet cookie to return
      locations.remove(cookieID); // remove cookie from locations
      components.remove(cookieID); // remove cookie from components
      field.get(pacManLocation).remove(Map.Type.COOKIE); // remove cookie from field

      cookies = cookies - 1; // update cookies
      return returnCookie;
    }

    return null; // no cookie where pacman is return null
  }
}
