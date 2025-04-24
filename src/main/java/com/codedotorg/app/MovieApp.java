package com.codedotorg.app;

import com.codedotorg.Movie;
import com.codedotorg.MovieDatabase;
import com.codedotorg.User;

import javafx.stage.Stage;
import java.util.ArrayList;

public class MovieApp extends AppScreen {
    
    /** The welcome screen of the app */
    private static WelcomeScreen welcomeScreen;

    /** The main screen of the app */
    private static MainScreen mainScreen;

    /** The screen that displays the list of movies */
    private static ViewMoviesScreen viewMoviesScreen;

    /** The screen that allows users to rate a movie */
    private static RateMovieScreen rateMovieScreen;

    /** The screen that displays the list of users */
    private static ViewUsersScreen viewUsersScreen;

    /** The screen that displays the movies a user has rated */
    private static UserRatingsScreen userRatingsScreen;

    /** The list of available movies */
    private static ArrayList<Movie> movies;

    /** The list of users on the app */
    private static ArrayList<User> users;

    /** The current user logged into the app */
    private static User currentUser;

    /**
     * This class represents the MovieApp which is the main class of the application.
     * It extends the App class and initializes the necessary screens and data structures.
     * 
     * @param window The main window of the application.
     * @param width The width of the main window.
     * @param height The height of the main window.
     */
    public MovieApp(Stage window, int width, int height) {
        super(window, width, height);

        users = new ArrayList<User>();
        movies = MovieDatabase.createMovieList();
        currentUser = null;

        welcomeScreen = new WelcomeScreen(window, width, height);
        mainScreen = new MainScreen(window, width, height);
        viewMoviesScreen = new ViewMoviesScreen(window, width, height);
        rateMovieScreen = new RateMovieScreen(window, width, height);
        viewUsersScreen = new ViewUsersScreen(window, width, height);
        userRatingsScreen = new UserRatingsScreen(window, width, height);
    }

    /**
     * This method starts the MovieApp by calling the startApp method of its
     * superclass and displaying the welcome screen.
     */
    public void startApp() {
        super.startApp("FlixRate");
        welcomeScreen.showScene();
    }

    /**
     * Returns the welcome screen of the MovieApp.
     *
     * @return the welcome screen of the MovieApp.
     */
    public static WelcomeScreen getWelcomeScreen() {
        return welcomeScreen;
    }

    /**
     * Returns the main screen of the MovieApp.
     *
     * @return the main screen of the MovieApp
     */
    public static MainScreen getMainScreen() {
        return mainScreen;
    }

    /**
     * Returns the ViewMoviesScreen object.
     *
     * @return the ViewMoviesScreen object
     */
    public static ViewMoviesScreen getViewMoviesScreen() {
        return viewMoviesScreen;
    }

    /**
     * Returns the RateMovieScreen object.
     *
     * @return the RateMovieScreen object.
     */
    public static RateMovieScreen getRateMovieScreen() {
        return rateMovieScreen;
    }

    /**
     * Returns the ViewUsersScreen object.
     *
     * @return the ViewUsersScreen object.
     */
    public static ViewUsersScreen getViewUsersScreen() {
        return viewUsersScreen;
    }

    /**
     * Returns the UserRatingsScreen object.
     *
     * @return the UserRatingsScreen object
     */
    public static UserRatingsScreen getUserRatingsScreen() {
        return userRatingsScreen;
    }

    /**
     * Sets the current user of the movie app.
     * 
     * @param newUser the new user to set as the current user
     */
    public static void setCurrentUser(User newUser) {
        currentUser = newUser;
    }

    /**
     * Returns the current user.
     *
     * @return the current user
     */
    public static User getCurrentUser() {
        return currentUser;
    }

    /**
     * Returns the list of movies.
     * 
     * @return the list of movies
     */
    public static ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * Returns an ArrayList of User objects.
     *
     * @return ArrayList of User objects.
     */
    public static ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Adds a new user to the list of users.
     * 
     * @param newUser the User object to be added
     */
    public static void addUser(User newUser) {
        users.add(newUser);
    }

}
