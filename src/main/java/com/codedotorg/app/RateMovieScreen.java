package com.codedotorg.app;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.codedotorg.AppLogic;
import com.codedotorg.Movie;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RateMovieScreen extends AppScreen {

    /**
     * This class represents a screen for rating a movie.
     * It extends the Screen class and takes a Stage, width, and height as parameters.
     * The RateMovieScreen constructor initializes the window, width, and height using the super constructor.
     */
    public RateMovieScreen(Stage window, int width, int height) {
        super(window, width, height);
    }

    /**
     * Displays the rate movie screen by creating a VBox layout and setting it as the current scene.
     */
    public void showScene() {
        VBox rateMovieLayout = createRateMovieScreen();
        setAndShowScene(rateMovieLayout);
    }

    /**
     * Creates a VBox layout for the Rate Movie screen.
     * 
     * @return the VBox layout for the Rate Movie screen
     */
    public VBox createRateMovieScreen() {
        VBox tempLayout = new VBox(10);
        tempLayout.setPadding(new Insets(10, 10, 10, 10));

        List<Node> componentsList = createComponents();

        tempLayout.getChildren().addAll(componentsList);

        return tempLayout;
    }

    /**
     * Creates and returns a list of UI components for the RateMovieScreen.
     * The list contains a movie dropdown, rating buttons, and a back button.
     *
     * @return a list of UI components for the RateMovieScreen
     */
    public List<Node> createComponents() {
        ComboBox<Movie> movieDropdown = createMovieDropdown();
        HBox ratingButtons = createRatingButtons(movieDropdown);
        Button backButton = getBackButton();

        List<Node> componentsList = Arrays.asList(movieDropdown, ratingButtons, backButton);

        return componentsList;
    }

    /**
     * Creates a dropdown menu of movies using a ComboBox object.
     * 
     * @return a ComboBox<Movie> object containing all the movies in the MovieApp.
     */
    public ComboBox<Movie> createMovieDropdown() {
        ComboBox<Movie> tempDropdown = new ComboBox<Movie>();

        for (Movie movie : MovieApp.getMovies()) {
            tempDropdown.getItems().add(movie);
        }
        
        return tempDropdown;
    }

    /**
     * Creates a horizontal box containing rating buttons for a given movie dropdown.
     * The rating buttons are numbered from 1 to 5.
     * When a rating button is clicked, it updates the rating of the selected movie in the dropdown
     * and shows a confirmation alert.
     *
     * @param movieDropdown the ComboBox containing the list of movies to rate
     * @return the HBox containing the rating buttons
     */
    public HBox createRatingButtons(ComboBox<Movie> movieDropdown) {
        HBox buttonLayout = new HBox(10);
        
        for (int index = 1; index <= 5; index++) {
            Button tempButton = new Button(String.valueOf(index));

            tempButton.setOnAction(event -> {
                updateRating(movieDropdown, Integer.parseInt(tempButton.getText()));
                showConfirmationAlert();
            });

            buttonLayout.getChildren().add(tempButton);
        }

        return buttonLayout;
    }

    /**
     * Updates the rating of a selected movie in the movie dropdown.
     * If a movie is selected, the rating is added to the movie's ratings list.
     * If no movie is selected, an alert is shown.
     *
     * @param movieDropdown The ComboBox containing the list of movies.
     * @param rating The rating to be added to the selected movie.
     */
    public void updateRating(ComboBox<Movie> movieDropdown, int rating) {
        AppLogic logic = new AppLogic();

        Movie selectedMovie = movieDropdown.getSelectionModel().getSelectedItem();

        if (selectedMovie != null) {
            logic.addMovieRating(selectedMovie, MovieApp.getCurrentUser(), rating);
            movieDropdown.getSelectionModel().clearSelection();
        }
        else {
            showNoMovieAlert();
        }
    }

    /**
     * Displays an error alert when no movie is selected to rate.
     */
    public void showNoMovieAlert() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("No movie selected!");
        alert.setHeaderText("Please select a movie to rate.");
        alert.showAndWait();
    }

    /**
     * Shows a confirmation alert to the user asking if they want to rate another movie.
     * If the user clicks OK, it calls the showScene() method to show the scene for rating another movie.
     * If the user clicks Cancel, it calls the showScene() method of the main screen to go back to the main screen.
     */
    public void showConfirmationAlert() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Rate another movie");
        alert.setHeaderText("Do you want to rate another movie?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            showScene();
        }
        else {
            MovieApp.getMainScreen().showScene();
        }
    }

}
