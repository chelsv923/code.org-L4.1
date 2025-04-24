package com.codedotorg.app;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppScreen {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scenes in the window */
    private int width;

    /** The height of the scenes in the window */
    private int height;

    /** The back button for the user to return to the main scene */
    private Button backButton;

    /**
     * Constructs an AppScreen object with the specified Stage window, width and height.
     * 
     * @param window the Stage window to be used for the AppScreen
     * @param width the width of the AppScreen
     * @param height the height of the AppScreen
     */
    public AppScreen(Stage window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;

        backButton = createBackButton();
    }

    /**
     * Sets the title of the application window.
     * 
     * @param title the title to set for the window
     */
    public void startApp(String title) {
        window.setTitle(title);
    }
    
    /**
     * Sets the given layout as the current scene and displays it on the window.
     * 
     * @param currentLayout the layout to be set as the current scene
     */
    public void setAndShowScene(VBox currentLayout) {
        Scene currentScene = new Scene(currentLayout, width, height);
        currentScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        window.setScene(currentScene);
        window.show();
    }

    /**
     * Returns the back button of the app screen.
     *
     * @return the back button of the app screen
     */
    public Button getBackButton() {
        return backButton;
    }

    /**
     * Creates a back button with the text "Back" and sets
     * its action to show the main screen of the MovieApp.
     * 
     * @return the created Button object
     */
    public Button createBackButton() {
        Button tempButton = new Button("Back");

        tempButton.setOnAction(event -> {
            MovieApp.getMainScreen().showScene();
        });

        return tempButton;
    }

}
