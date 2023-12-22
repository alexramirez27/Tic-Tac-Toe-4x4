package ca.cmpt213.asn4.tictactoe;

import ca.cmpt213.asn4.tictactoe.ui.BoardLayout;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Class TicTac. Contains the main method that is used to run the game. This game uses the javafx library.
 * In the main method, the launch method is called which in turn calls the static method startContent.
 * The method startContent initializes the whole board and is ready to process the game logic.
 * @author Alex Ramirez
 * @version 1.0
 */
public class TicTac extends Application {
    public static void main(String[] args) 
    {
        // Launch the application
        launch();        
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        BoardLayout.startContent(primaryStage);
    }

}