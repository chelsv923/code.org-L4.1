package com.codedotorg;

public class Rating {
    
    /** The user submitting the rating */
    private User user;

    /** The movie the user is rating */
    private Movie movie;

    /** The score the user gave for the movie */
    private int score;

    /**
     * Constructs a Rating object with the given User, Movie, and score.
     *
     * @param user the User who is rating the Movie
     * @param movie the Movie being rated
     * @param score the score given to the Movie by the User
     */
    public Rating(User user, Movie movie, int score) {
        this.user = user;
        this.movie = movie;
        this.score = score;
    }

    /**
     * Returns the user associated with this rating.
     *
     * @return the user associated with this rating
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the movie associated with this rating.
     * 
     * @return the movie associated with this rating
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Returns the score of the rating.
     *
     * @return the score of the rating
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns a string representation of the Rating object.
     * The string contains the name of the movie and its score separated by a hyphen.
     * 
     * @return a string representation of the Rating object.
     */
    public String toString() {
        return movie + "\nYour Rating: " + score;
    }

}
