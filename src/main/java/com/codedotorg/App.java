package com.codedotorg;

import com.codedotorg.app.MovieApp;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) {
        MovieApp movies = new MovieApp(primaryStage, 500, 500);
        movies.startApp();
    }

}
