package com.codedotorg.app;

import com.codedotorg.User;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewUsersScreen extends AppScreen {

    /**
     * This class represents a screen for viewing users. It extends the Screen class and
     * takes in a Stage object, width and height as parameters. The constructor initializes
     * the ViewUsersScreen object with the given parameters.
     *
     * @param window The Stage object representing the window of the screen.
     * @param width The width of the screen.
     * @param height The height of the screen.
     */
    public ViewUsersScreen(Stage window, int width, int height) {
        super(window, width, height);
    }
    
    /**
     * Displays the view users screen by creating the layout and setting it as the current scene.
     * The layout is created using the createViewUsersLayout method.
     */
    public void showScene() {
        VBox viewUsersLayout = createViewUsersLayout();
        setAndShowScene(viewUsersLayout);
    }

    /**
     * Creates a VBox layout that contains a ListView of users and a back button.
     * 
     * @return the VBox layout
     */
    public VBox createViewUsersLayout() {
        VBox tempLayout = new VBox(10);
        tempLayout.setPadding(new Insets(10, 10, 10, 10));

        ListView<User> userListView = createListView();
        Button backButton = getBackButton();

        tempLayout.getChildren().addAll(userListView, backButton);

        return tempLayout;
    }

    /**
     * Creates a ListView of all users in the MovieApp.
     *
     * @return the ListView of users
     */
    public ListView<User> createListView() {
        ListView<User> userListView = new ListView<User>();

        userListView.getItems().clear();
        
        for (User user : MovieApp.getUsers()) {
            userListView.getItems().add(user);
        }

        return userListView;
    }

}
