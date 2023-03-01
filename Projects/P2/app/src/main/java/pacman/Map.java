package pacman;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;
import javax.tools.DocumentationTool.Location;

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
    if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
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
    return false;
  }

  public HashSet<Type> getLoc(Location loc) {
    // wallSet and emptySet will help you write this method
    return null;
  }

  public boolean attack(String Name) {
    // update gameOver
    return false;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
	    
	Location pacManLocation = locations.get(name); //get pacman's location
	if(field.get(pacManLocation).contains(Map.Type.COOKIE)) { // check if there is a cookie where pacman is located
		String cookieID = "tok_x" + pacManLocation.x + "_y" + pacManLocation.y; //create the cookie ID string
		JComponent returnCookie = components.get(cookieID); // save the JComponet cookie to return
		locations.remove(cookieID); //remove cookie from locations
		components.remove(cookieID); //remove cookie from components
		field.get(pacManLocation).remove(Map.Type.COOKIE); //remove cookie from field
		cookies = cookies - 1; // update cookies
		return returnCookie;
	}
	
    /*for(HashSet<Type> set: field.values()){
      if(set.contains(Map.Type.PACMAN)){
        pacManLocation = field.getValue(set);
        if(set.contains(Map.Type.COOKIE)){
          cookies = cookies - 1;
          
          return Map.Type.COOKIE;
        } else {
          return null;
        }
      }
    }*/
    return null; //no cookie where pacman is return null
  }
}
