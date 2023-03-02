# PacMan Project - Team 3
Team Members: Mahinsa, Jasneet, Isabella, Ashley

## Code Playing Pacman

## How to Run the Code
To run the code, make sure you have gradle installed and you are in the project directory. Then type the commands listed below in your command line. The game should be running after that.

```
gradle build
gradle run
```
---
## Pacman Functions

### move()
This function works by using the get_valid_moves() function to determine where Pacman can go. It uses a random number generator to select a possible move from the list from get_valid_moves and then calls Map’s move function to move Pacman on the map.

The tests work by creating a frame, a map, and pacman. The pacman has been set to a specific location. After that, it calls get_valid_moves() on pacman to see the possible moves. Then move is called on pacman which should return true because there is at least one possible move. To finalize that the move was sucessful, pacman's new location should be one of the possible moves retrieved from get_valid_moves().

### consume()
This function is used to call the eatCookie function from within the pacman class. The function checks if at pacmans location on the map there is a cookie. if there is a cookie it calls the eatCookie function on the map with the parameter "pacman". If there is no cookie at pacman's location it returns null.

To test this function I initalized a frame with MainFrame and placed pacman where there were not any cookies and asserted that pacman.consume() would return null in this case. I then added a cookie at pacman's location. i then asserted that calling pacman.consume() would no longer return null.

---
## Ghost Functions

### move()
This function works by using the get_valid_moves() function to determine where the ghost can go. It uses a random number generator to select a possible move from the list from get_valid_moves and then calls Map’s move function to move the ghost on the map.

The tests work by creating a frame, a map, and a ghost. The ghost has been set to a specific location with at least 1 valid move. After that, it calls get_valid_moves() on the ghost to see the possible moves. Then move is called on ghost which should return true because there is at least one possible move. To finalize that the move was sucessful, the ghost's new location should be one of the possible moves retrieved from get_valid_moves().

## attack()
This function is used to call the attack function from map if pacman is in range. the function uses is_pacman_in_range function to see if an attack is possible. If it is it calls attack on the map and returns true. otherwise it will return false.

To test this function I created a mainframe and added pacman to the map. I then add a ghost out of range and call the atttac function and assert it returns false. I then add a ghost within range of pacman and assert that using the attack function in this case returns true. 

---
## Map Functions
### getLoc()
This function works by utilizing the functions in field. It first determines if the location exists by checking if the field contains the location. If it does, 
it returns the ArrayList associated with the location in field. Or else the WallSet is returned.

The tests work by creating a frame and a map. The getLoc() function is then called on a few locations that has known components. These known components are stored in a hashset which is then compared to the results from the function call. Assertions are made to determine that the two are equal to determine that the function call worked.

### eatCookie(String Name)
This function is used by the consume function in the pacman class in order to update the map's location, components, and field HashMap as well as the cookies counter. it does this using pacmans location to find the cookie in all these hashmaps and remove them. If there is no cookie at pacmans location the function returns null. If there was a cookie at pacman's location the function returns the cookie component. 

To test this function I created a MainFrame, initalizing the pacman game. I then added pacman to the map at a location where there was also a cookie. I then called the eatCookie function on the mainframes map with the argument pacman. If pacman eats the cookie and the counter decrements the test passes. If pacman eats the cookie and the counter does not decrement the test fails.
