package com.codedotorg.app;

import java.util.Arrays;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScreen extends AppScreen {

    /**
     * Constructs a MainScreen object with the specified Stage, width, and height.
     *
     * @param window the Stage object to be used for the MainScreen
     * @param width the width of the MainScreen
     * @param height the height of the MainScreen
     */
    public MainScreen(Stage window, int width, int height) {
        super(window, width, height);        
    }
    
    /**
     * Displays the main screen by creating a VBox layout and setting it as the scene.
     */
    public void showScene() {
        VBox mainLayout = createMainScreen();
        setAndShowScene(mainLayout);
    }

    /**
     * Creates the main screen layout for the MovieApp.
     * 
     * @return the VBox layout containing the main screen components
     */
    public VBox createMainScreen() {
        VBox tempLayout = new VBox(10);
        tempLayout.setPadding(new Insets(10, 10, 10, 10));

        String currentUsername = MovieApp.getCurrentUser().getName();
        List<Node> componentsList = createComponents(currentUsername);

        tempLayout.getChildren().addAll(componentsList);

        return tempLayout;
    }

    /**
     * Creates a list of UI components for the main screen of the application.
     * 
     * @param username the username of the current user
     * @return a list of UI components including a greeting label, buttons to view movies,
     *         rate a movie, view users, switch user, view user ratings, and quit the application
     */
    public List<Node> createComponents(String username) {
        Label greetingLabel = new Label("Hi " + username + "!");
        Button viewMoviesButton = createButton("View Movies");
        Button rateMovieButton = createButton("Rate a Movie");
        Button viewUsersButton = createButton("View Users");
        Button switchUserButton = createButton("Switch User");
        Button userRatingsButton = createButton("View Your Ratings");
        Button quitButton = createButton("Quit");

        List<Node> componentsList = Arrays.asList(greetingLabel, viewMoviesButton, rateMovieButton,
            viewUsersButton, switchUserButton, userRatingsButton, quitButton);

        return componentsList;
    }

    /**
     * Creates a button with the given text and sets its action based on the text.
     * If the text is "View Movies", the button will show the view movies screen.
     * If the text is "Rate a Movie", the button will show the rate movie screen.
     * If the text is "View Users", the button will show the view users screen.
     * If the text is "Switch User", the button will show the welcome screen.
     * If the text is "View Your Ratings", the button will show the user ratings screen.
     * If the text is anything else, the button will exit the application.
     *
     * @param buttonText the text to be displayed on the button
     * @return the created button with the appropriate action set
     */
    public Button createButton(String buttonText) {
        Button tempButton = new Button(buttonText);

        if (buttonText.equals("View Movies")) {
            tempButton.setOnAction(event -> {
                MovieApp.getViewMoviesScreen().showScene();
            });
        }
        else if (buttonText.equals("Rate a Movie")) {
            tempButton.setOnAction(event -> {
               MovieApp.getRateMovieScreen().showScene();
            });
        }
        else if (buttonText.equals("View Users")) {
            tempButton.setOnAction(event -> {
                MovieApp.getViewUsersScreen().showScene();
            });
        }
        else if (buttonText.equals("Switch User")) {
            tempButton.setOnAction(event -> {
                MovieApp.getWelcomeScreen().showScene();
            });
        }
        else if (buttonText.equals("View Your Ratings")) {
            tempButton.setOnAction(event -> {
                MovieApp.getUserRatingsScreen().showScene();
            });
        }
        else {
            tempButton.setOnAction(event -> {
                System.exit(0);
            });
        }

        return tempButton;
    }

}
