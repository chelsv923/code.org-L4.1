package com.codedotorg;

import java.util.ArrayList;

public class User {
    
    /** The name of the user */
    private String name;

    /** The list of ratings the user has submitted */
    private ArrayList<Rating> ratings;

    /**
     * Constructs a new User object with the given name and an empty list of ratings.
     * 
     * @param name the name of the user
     */
    public User(String name) {
        this.name = name;
        this.ratings = new ArrayList<Rating>();
    }

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of ratings for this user.
     *
     * @return the list of ratings for this user
     */
    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    /**
     * Adds a rating for a movie by this user.
     * 
     * @param movie the movie being rated
     * @param score the score given by the user for the movie
     */
    public void addRating(Movie movie, int score) {
        ratings.add(new Rating(this, movie, score));
    }

    /**
     * Returns a string representation of the User object.
     * The string contains the user's name and the number of movies rated by the user.
     *
     * @return a string representation of the User object.
     */
    public String toString() {
        return name + ": " + ratings.size() + " movies rated";
    }

}
