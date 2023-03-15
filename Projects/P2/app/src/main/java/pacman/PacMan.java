package pacman;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import javax.swing.JComponent;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;
  Location shift;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    ArrayList<Location> moves = new ArrayList<Location>();
    int currX = this.myLoc.x;
    int currY = this.myLoc.y;

    HashSet<Map.Type> left = myMap.getLoc(new Location(currX-1, currY));
    HashSet<Map.Type> right = myMap.getLoc(new Location(currX+1, currY));
    HashSet<Map.Type> up = myMap.getLoc(new Location(currX, currY+1));
    HashSet<Map.Type> down = myMap.getLoc(new Location(currX, currY-1)); 

    // check each move, if its not null (not out of bounds), and not a wall, add to valid moves
    if(!left.contains(Map.Type.WALL)){
      moves.add(new Location(currX-1, currY));
    }
    if(!right.contains(Map.Type.WALL)){
      moves.add(new Location(currX+1, currY));
    }
    if(!up.contains(Map.Type.WALL)){
      moves.add(new Location(currX, currY+1));
    }
    if(!down.contains(Map.Type.WALL)){
      moves.add(new Location(currX, currY-1));
    }
    return moves;
  }

  public boolean move() {
    ArrayList<Location> locs = get_valid_moves();
    if (locs.isEmpty()){
      return true;
    }
    
    Random rand = new Random();
    Location loc = locs.get(rand.nextInt(locs.size()));
    if (myMap.move(myName, loc, Map.Type.PACMAN) == true) {
      myLoc = loc;
    }
    return false;
  }

  public boolean is_ghost_in_range() {
    int x = this.myLoc.x;
    int y = this.myLoc.y;
    
    if (myMap.getLoc(new Location(x+1,y)).contains(Map.Type.GHOST)){
      return true;
    }
    if (myMap.getLoc(new Location(x-1,y)).contains(Map.Type.GHOST)){
      return true;
    }
    if (myMap.getLoc(new Location(x+1,y+1)).contains(Map.Type.GHOST)){
      return true;
    }
    if (myMap.getLoc(new Location(x-1,y-1)).contains(Map.Type.GHOST)){
      return true;
    }
    if (myMap.getLoc(new Location(x,y+1)).contains(Map.Type.GHOST)){
      return true;
    }
    if (myMap.getLoc(new Location(x,y-1)).contains(Map.Type.GHOST)){
      return true;
    }
    if (myMap.getLoc(new Location(x-1,y+1)).contains(Map.Type.GHOST)){
      return true;
    }
    if (myMap.getLoc(new Location(x+1,y-1)).contains(Map.Type.GHOST)){
      return true;
    }
    return false;
  }

  public JComponent consume() {
    if(myMap.getLoc(myLoc).contains(Map.Type.COOKIE)){
      return myMap.eatCookie("pacman");
    } else {
      return null;
    }
  }
}
