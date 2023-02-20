package pacman;
import java.util.ArrayList;
import java.util.HashSet;
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
    if(left!=null && !left.contains(Map.Type.WALL)){
      moves.add(new Location(currX-1, currY));
    }
    if(right!=null && !right.contains(Map.Type.WALL)){
      moves.add(new Location(currX+1, currY));
    }
    if(up!=null && !up.contains(Map.Type.WALL)){
      moves.add(new Location(currX, currY+1));
    }
    if(down!=null && !down.contains(Map.Type.WALL)){
      moves.add(new Location(currX, currY-1));
    }
    return moves;
  }

  public boolean move() {
    return false;
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
