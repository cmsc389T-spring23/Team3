# PacMan Project - Team 3
Team Members: Mahinsa, Jasneet, Isabella, Ashley

---
## Code Playing Pacman

---
## How to Run the Code


---
## Pacman Functions

### move()
This function works by using the get_valid_moves() function to determine where Pacman can go. It uses a random number generator to select a possible move from the list from get_valid_moves and then calls Map’s move function to move Pacman on the map.

The tests work by creating a frame, a map, and pacman. The pacman has been set to a specific location. After that, it calls get_valid_moves() on pacman to see the possible moves. Then move is called on pacman which should return true because there is at least one possible move. To finalize that the move was sucessful, pacman's new location should be one of the possible moves retrieved from get_valid_moves().

---
## Ghost Functions

### move()
This function works by using the get_valid_moves() function to determine where the ghost can go. It uses a random number generator to select a possible move from the list from get_valid_moves and then calls Map’s move function to move the ghost on the map.

The tests work by creating a frame, a map, and a ghost. The ghost has been set to a specific location with at least 1 valid move. After that, it calls get_valid_moves() on the ghost to see the possible moves. Then move is called on ghost which should return true because there is at least one possible move. To finalize that the move was sucessful, the ghost's new location should be one of the possible moves retrieved from get_valid_moves().

---
## Map Functions
### getLoc()
This function works by utilizing the functions in field. It first determines if the location exists by checking if the field contains the location. If it does, 
it returns the ArrayList associated with the location in field. Or else the WallSet is returned.

The tests work by creating a frame and a map. The getLoc() function is then called on a few locations that has known components. These known components are stored in a hashset which is then compared to the results from the function call. Assertions are made to determine that the two are equal to determine that the function call worked.
