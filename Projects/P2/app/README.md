# PacMan Project - Team 3

### Team Members: Mahinsa, Jasneet, Isabella, Ashley
---
## Code Playing Pacman

---
## How to Run the Code


---
## Pacman Functions

### move()
This function works by using the get_valid_moves() function to determine where Pacman can go. It uses a random number generator to select a possible move 
from the list from get_valid_moves and then calls Map’s move function to move Pacman on the map.

---
## Ghost Functions

### move()
This function works by using the get_valid_moves() function to determine where the ghost can go. It uses a random number generator to select a possible move 
from the list from get_valid_moves and then calls Map’s move function to move the ghost on the map.

---
## Map Functions
### getLoc()
This function works by utilizing the functions in field. It first determines if the location exists by checking if the field contains the location. If it does, 
it returns the ArrayList associated with the location in field. Or else the WallSet is returned.
