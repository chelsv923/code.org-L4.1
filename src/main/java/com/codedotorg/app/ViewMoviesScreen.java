package com.codedotorg.app;

import com.codedotorg.Movie;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewMoviesScreen extends AppScreen {

    /**
     * Constructs a ViewMoviesScreen object with the specified window, width, and height.
     * 
     * @param window the Stage object to display the screen on
     * @param width the width of the screen
     * @param height the height of the screen
     */
    public ViewMoviesScreen(Stage window, int width, int height) {
        super(window, width, height);
    }

    /**
     * Displays the view movies screen by creating a VBox layout and setting it as the scene.
     */
    public void showScene() {
        VBox viewMoviesLayout = createViewMoviesScreen();
        setAndShowScene(viewMoviesLayout);
    }

    /**
     * Creates a VBox layout that contains a ListView of movies and a back button.
     * 
     * @return the VBox layout
     */
    public VBox createViewMoviesScreen() {
        VBox tempLayout = new VBox(10);
        tempLayout.setPadding(new Insets(10, 10, 10, 10));

        ListView<Movie> moviesListView = createListView();
        Button backButton = getBackButton();

        tempLayout.getChildren().addAll(moviesListView, backButton);

        return tempLayout;
    }

    /**
     * Creates a ListView of movies by iterating through the list of movies in the MovieApp class.
     * 
     * @return The ListView of movies.
     */
    public ListView<Movie> createListView() {
        ListView<Movie> listView = new ListView<Movie>();

        for (Movie movie : MovieApp.getMovies()) {
            listView.getItems().add(movie);
        }

        return listView;
    }

}
