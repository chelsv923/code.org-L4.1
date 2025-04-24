package com.codedotorg;

import java.util.ArrayList;

public class AppLogic {
    
    /**
     * Adds a rating for a movie by a user.
     * 
     * @param selectedMovie the movie to add the rating for
     * @param currentUser the user who is adding the rating
     * @param rating the rating to add (between 1 and 5)
     */
    public void addMovieRating(Movie selectedMovie, User currentUser, int rating) {
        selectedMovie.addRating(currentUser, rating);
        currentUser.addRating(selectedMovie, rating);
    }

    /**
     * Returns an existing user from the given list of users with the specified username.
     *
     * @param usersList the list of users to search through
     * @param username the username of the user to find
     * @return the User object with the specified username, or null if no such user exists
     */
    public User getExistingUser(ArrayList<User> usersList, String username) {
        User foundUser = null;

        for (int index = 0; index < usersList.size(); index++) {
            User currentUser = usersList.get(index);

            if (currentUser.getName().equals(username)) {
                foundUser = currentUser;
            }
        }

        return foundUser;
    }

    /**
     * Creates a new user with the given username.
     *
     * @param username the username for the new user
     * @return a new User object with the given username
     */
    public User createNewUser(String username) {
        return new User(username);
    }

    /**
     * Checks if a given username exists in the provided list of users.
     * 
     * @param usersList the list of users to search through
     * @param username the username to search for
     * @return true if the username is found in the list, false otherwise
     */
    public boolean isUsernameExists(ArrayList<User> usersList, String username) {
        boolean found = false;

        for (int index = 0; index < usersList.size(); index++) {
            User currentUser = usersList.get(index);

            if (currentUser.getName().equals(username)) {
                found = true;
            }
        }

        return found;
    }

}
