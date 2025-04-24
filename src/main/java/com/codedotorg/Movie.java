package com.codedotorg;

import java.util.ArrayList;

public class Movie {
    
    /** The title of the movie */
    private String title;

    /** The year the movie was released */
    private int releaseYear;

    /** The list of ratings for the movie */
    private ArrayList<Rating> ratings;

    /**
     * Constructs a new Movie object with the given title and release year.
     * Initializes an empty list of ratings.
     *
     * @param title the title of the movie
     * @param releaseYear the year the movie was released
     */
    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.ratings = new ArrayList<Rating>();
    }

    /**
     * Returns the title of the movie.
     * 
     * @return the title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the release year of the movie.
     *
     * @return the release year of the movie
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Returns the list of ratings for this movie.
     *
     * @return the list of ratings for this movie
     */
    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    /**
     * Adds a rating for this movie from the given user with the given score.
     * 
     * @param user the user who is rating the movie
     * @param score the score given by the user, must be between 1 and 5 (inclusive)
     */
    public void addRating(User user, int score) {
        ratings.add(new Rating(user, this, score));
    }

    /**
     * Returns the average rating of the movie based on all the ratings it has received.
     * If the movie has not been rated yet, returns 0.
     *
     * @return the average rating of the movie
     */
    public double getAverageRating() {
        if (ratings.size() == 0) {
            return 0;
        }

        double total = 0;

        for (int index = 0; index < ratings.size(); index++) {
            total += ratings.get(index).getScore();
        }

        return total / ratings.size();
    }

    /**
     * Returns a string representation of the Movie object.
     * The string contains the movie's title, release year, and average rating.
     *
     * @return a string representation of the Movie object
     */
    public String toString() {
        return title + " (" + releaseYear + "): " + getAverageRating();
    }

}
