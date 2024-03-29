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

### get_valid_moves()
The purpose of this function is to return all possible moves that the pacman can potentially take. These moves are collected in an ArrayList of Locations which is returned upon the completion of the method. To get all valid moves, I check the contents of each location that is one move away from the pacman's location. This includes checking at the location left, right, up, and down. If any of the locations are a wall, they are not valid and will not be returned. If they are anything but a wall, they are a valid move and will be contained in the arraylist returned.

To test this function in testPacManValidMoves(), I created a MainFrame which initializes a game simulation. To do initial tests of pacman, I created a pacman object and added it to the frame. After running the game, I could place the pacman at a location where I knew what the valid moves should be. The test correctly returns all the locations that are not walls. To test that the function still returns a location with a ghost, I created a ghost and added it to the map. I then ran the test again and it returned the same correct locations of valid moves for the pacman.

### is_ghost_in_range()
This function checks every set of coordinates around pacman's current location and returns true if any of them contain a Ghost object, and false otherwise.

To test, I made a sample frame that adds a pacman and ghost within range of each other, and then checks if pacman can see the ghost in range.

### consume()
This function is used to call the eatCookie function from within the pacman class. The function checks if at pacmans location on the map there is a cookie. if there is a cookie it calls the eatCookie function on the map with the parameter "pacman". If there is no cookie at pacman's location it returns null.

To test this function I initalized a frame with MainFrame and placed pacman where there were not any cookies and asserted that pacman.consume() would return null in this case. I then added a cookie at pacman's location. i then asserted that calling pacman.consume() would no longer return null.

---
## Ghost Functions

### move()
This function works by using the get_valid_moves() function to determine where the ghost can go. It uses a random number generator to select a possible move from the list from get_valid_moves and then calls Map’s move function to move the ghost on the map.

The tests work by creating a frame, a map, and a ghost. The ghost has been set to a specific location with at least 1 valid move. After that, it calls get_valid_moves() on the ghost to see the possible moves. Then move is called on ghost which should return true because there is at least one possible move. To finalize that the move was sucessful, the ghost's new location should be one of the possible moves retrieved from get_valid_moves().


### get_valid_moves()
The purpose of this function is to return all possible moves that a ghost can potentially take. These moves are collected in an ArrayList of Locations which is returned upon the completion of the method. To get all valid moves, I check the contents of each location that is one move away from the ghost's location. This includes checking at the location left, right, up, and down. If any of the locations are a wall, they are not valid and will not be returned. If they are anything but a wall, they are a valid move and will be contained in the arraylist returned.

To test this function in testGhostValidMoves(), I created a MainFrame which initializes a game simulation. To do initial tests of ghost, I created a pacman object and added it to the frame. After running the game, I could place the ghost at a location where I knew what the valid moves should be. The test correctly returns all the locations that are not walls. To test that the function still returns a location with another ghost, I created a second ghost and added it to the map. I then ran the test again and it returned the same correct locations of valid moves for the ghost since that ghost is allowed to go through another ghost.

### is_pacman_in_range()
This function is used by the Ghost class to check if pacman is within attack distance, doing so by checking the surrounding coordinates for pacman type objects.

The test is the same as the test for is_ghost_in_range() but with the logic called by the ghost instead of pacman.

## attack()
This function is used to call the attack function from map if pacman is in range. the function uses is_pacman_in_range function to see if an attack is possible. If it is it calls attack on the map and returns true. otherwise it will return false.

To test this function I created a mainframe and added pacman to the map. I then add a ghost out of range and call the atttac function and assert it returns false. I then add a ghost within range of pacman and assert that using the attack function in this case returns true. 

---
## Map Functions
### getLoc()
This function works by utilizing the functions in field. It first determines if the location exists by checking if the field contains the location. If it does, 
it returns the ArrayList associated with the location in field. Or else the WallSet is returned.

The tests work by creating a frame and a map. The getLoc() function is then called on a few locations that has known components. These known components are stored in a hashset which is then compared to the results from the function call. Assertions are made to determine that the two are equal to determine that the function call worked.


### move()
The purpose of this function is to take care of the Map object components when an object (pacman, ghost) is moved. For this function, name of the object, the new intended location, and the Type of the object is provided. First, we check the new location and make sure it is not a wall because that would be an invalid move. If it is a wall, this function returns false. Next, the function checks if the field is the type pacman. If so, we make the necesary adjustments to get the old location of the pacman and remove the pacman from there, add the pacman to the new object, and update name with the associated location in "locations" and "components". We then do the same if we are moving a ghost object. These changes will collectivy reflect an object moving on themap. This function returns true once these fields are updated. 

To test this function in testMapMove(), I created a MainFrame which initializes a game simulation. To start, I added a ghost and pacman to the frame at locations close together. Then I moved the pacman to the location of the ghost. This successfully returned true and I was able to check that the location I moved it to now contains pacman. I then tested move on the ghost by moving the ghost to another location. I verified that the ghost was moved and the old location no longer had a ghost component and the new location did. These tests indicate move is working correctly.

### attack(String name)
This function is used by the map class to end the game when pacman is attacked. If the ghost which called it is able to attack pacman it returns true and updates gameover to be true. In order to do this it utilizes the same logic as the ghost/pacman is _ in range functions, it uses the provided ghost name to locate which ghost is trying to attack, and then validates that attack by returning true or false.

To test this function the test creates a board with a ghost in range of pacman, and then checks if map attack will correctly return true when the named ghost attacks pacman.


### eatCookie(String Name)
This function is used by the consume function in the pacman class in order to update the map's location, components, and field HashMap as well as the cookies counter. it does this using pacmans location to find the cookie in all these hashmaps and remove them. If there is no cookie at pacmans location the function returns null. If there was a cookie at pacman's location the function returns the cookie component. 

To test this function I created a MainFrame, initalizing the pacman game. I then added pacman to the map at a location where there was also a cookie. I then called the eatCookie function on the mainframes map with the argument pacman. If pacman eats the cookie and the counter decrements the test passes. If pacman eats the cookie and the counter does not decrement the test fails.