package pacman;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
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

    // check each move, add to valid moves if position checked is not a wall
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
    if (locs.isEmpty()) {
      return false;
    }
    Random rand = new Random();
    Location loc = locs.get(rand.nextInt(locs.size()));
    if (myMap.move(myName, loc, Map.Type.GHOST) == true) {
      myLoc = loc;
    }
    return true;
  }

  public boolean is_pacman_in_range() {
    int x = this.myLoc.x;
    int y = this.myLoc.y;
    
    if (myMap.getLoc(new Location(x+1,y)).contains(Map.Type.PACMAN)){
      return true;
    }
    if (myMap.getLoc(new Location(x-1,y)).contains(Map.Type.PACMAN)){
      return true;
    }
    if (myMap.getLoc(new Location(x+1,y+1)).contains(Map.Type.PACMAN)){
      return true;
    }
    if (myMap.getLoc(new Location(x-1,y-1)).contains(Map.Type.PACMAN)){
      return true;
    }
    if (myMap.getLoc(new Location(x,y+1)).contains(Map.Type.PACMAN)){
      return true;
    }
    if (myMap.getLoc(new Location(x,y-1)).contains(Map.Type.PACMAN)){
      return true;
    }
    if (myMap.getLoc(new Location(x-1,y+1)).contains(Map.Type.PACMAN)){
      return true;
    }
    if (myMap.getLoc(new Location(x+1,y-1)).contains(Map.Type.PACMAN)){
      return true;
    }
    return false;
  }

  public boolean attack() {
    if(this.is_pacman_in_range()){
        myMap.attack(myName);
        return true;
    } else {
      return false;
    }
    
  }
}
