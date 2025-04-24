package com.codedotorg.app;

import java.util.ArrayList;

import com.codedotorg.AppLogic;
import com.codedotorg.User;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeScreen extends AppScreen {

    /** The text field for the user to enter their name */
    private TextField nameInput;

    /**
     * Constructs a WelcomeScreen object with the specified window, width, and height.
     * Initializes a TextField for user input.
     *
     * @param window the Stage object to display the WelcomeScreen on
     * @param width the width of the WelcomeScreen
     * @param height the height of the WelcomeScreen
     */
    public WelcomeScreen(Stage window, int width, int height) {
        super(window, width, height);

        nameInput = new TextField();
    }
    
    /**
     * Displays the welcome screen by creating a VBox layout and setting it as the scene.
     */
    public void showScene() {
        VBox welcomeLayout = createWelcomeScreen();
        setAndShowScene(welcomeLayout);
    }

    /**
     * Creates a VBox layout for the welcome screen.
     * 
     * @return the VBox layout for the welcome screen
     */
    public VBox createWelcomeScreen() {
        VBox tempLayout = new VBox(10);
        tempLayout.setPadding(new Insets(10, 10, 10, 10));

        Label nameLabel = new Label("Welcome! What's your name?");

        tempLayout.getChildren().addAll(nameLabel, nameInput, createSubmitButton());

        return tempLayout;
    }

    /**
     * Creates a submit button that, when clicked, sets or switches the user
     * to the name entered in the name input field, shows the main screen,
     * and clears the name input field.
     *
     * @return the submit button
     */
    public Button createSubmitButton() {
        Button submitButton = new Button("Submit");

        submitButton.setOnAction(e -> {
            if (!nameInput.getText().isEmpty()) {
                String username = nameInput.getText();
                setOrSwitchUser(username);
                MovieApp.getMainScreen().showScene();
                nameInput.clear();
            }
        });

        return submitButton;
    }

    /**
     * Sets or switches the current user to the given username.
     * If the username already exists in the list of users, sets the current user to that user.
     * Otherwise, creates a new user with the given username and adds it to the list of users.
     * 
     * @param username the username of the user to set or switch to
     */
    public void setOrSwitchUser(String username) {
        AppLogic logic = new AppLogic();
        User currentUser = logic.createNewUser(username);;

        MovieApp.addUser(currentUser);
        MovieApp.setCurrentUser(currentUser);
    }

}
