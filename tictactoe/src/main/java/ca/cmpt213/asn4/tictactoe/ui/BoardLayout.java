package ca.cmpt213.asn4.tictactoe.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import ca.cmpt213.asn4.tictactoe.game.Board;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class BoardLayout. Represents the user interface of the tic-tac-toe board.
 * Includes event handlers for the boxes and for the button. Boxes are filled with X's and O's
 * @author Alex Ramirez
 * @version 1.0
 */
public class BoardLayout {
    static int moduloValue = 0;
    public static void startContent(Stage primaryStage) 
    {
        // Set the stage title
        primaryStage.setTitle("Tic-Tac-Toe");

        Text xText = new Text("X Wins!");
        xText.setFont(new Font(18));
        xText.setX(195);
        xText.setY(15);
        xText.setVisible(false);

        Text oText = new Text("O Wins!");
        oText.setFont(new Font(18));
        oText.setX(195);
        oText.setY(15);
        oText.setVisible(false);

        Text drawText = new Text("Draw!");
        drawText.setFont(new Font(18));
        drawText.setX(205);
        drawText.setY(15);
        drawText.setVisible(false);

        Pane textPane = new Pane(xText, oText, drawText);
        
        Button button = new Button();
        button.setText("New Game");
        button.setMinWidth(150);
        button.setMinHeight(40);
        button.setStyle("-fx-font-size: 18");
        button.setVisible(false);

        // Create a GridPane
        GridPane gridPane = new GridPane();

        Color myLightGrey = Color.rgb(238, 236, 225);

        // Add the rectangles to the gridpane
        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 4; j++ ) {
                Rectangle rectangle = new Rectangle(75, 75);
                rectangle.setFill(myLightGrey);
                rectangle.setX(1);
                rectangle.setY(1);

                try {
                    FileInputStream inputStreamX = new FileInputStream("./tictactoe/src/main/java/ca/cmpt213/asn4/tictactoe/ui/images/xImage.jpg");
                    Image imageX = new Image(inputStreamX);
                    ImageView imageViewX = new ImageView(imageX);
                    imageViewX.setX(1);
                    imageViewX.setY(1);
                    imageViewX.setFitWidth(76);
                    imageViewX.setFitHeight(76);
                    imageViewX.setVisible(false);

                    FileInputStream inputStreamO = new FileInputStream("./tictactoe/src/main/java/ca/cmpt213/asn4/tictactoe/ui/images/oImage.jpg");
                    Image imageO = new Image(inputStreamO);
                    ImageView imageViewO = new ImageView(imageO);
                    imageViewO.setFitWidth(76);
                    imageViewO.setFitHeight(76);
                    imageViewO.setX(1);
                    imageViewO.setY(1);
                    imageViewO.setVisible(false);

                    FileInputStream inputStreamEmpty = new FileInputStream("./tictactoe/src/main/java/ca/cmpt213/asn4/tictactoe/ui/images/emptyImage.jpg");
                    Image imageEmpty = new Image(inputStreamEmpty);
                    ImageView imageViewEmpty = new ImageView(imageEmpty);
                    imageViewEmpty.setFitWidth(76);
                    imageViewEmpty.setFitHeight(76);
                    imageViewEmpty.setX(1);
                    imageViewEmpty.setY(1);
                    imageViewEmpty.setVisible(false);
                    
                    Pane currentPane = new Pane(rectangle, imageViewX, imageViewO, imageViewEmpty);
                    currentPane.setStyle("-fx-border-color: black;-fx-border-style: solid;");
                    
                    gridPane.add(currentPane, j, i);
                    
                    EventHandler<javafx.scene.input.MouseEvent> eventHandler = 
                        new EventHandler<javafx.scene.input.MouseEvent>() { 
                        
                        @Override 
                        public void handle(javafx.scene.input.MouseEvent e) { 
                            int boxIndex = gridPane.getChildren().indexOf(currentPane);
                            int row = 0;
                            int col = boxIndex % 4;

                            if ( boxIndex < 4 ) {
                                row = 0;
                            }
                            else if ( boxIndex < 8 ) {
                                row = 1;
                            }
                            else if ( boxIndex < 12 ) {
                                row = 2;
                            }
                            else {
                                row = 3;
                            }

                            if ( moduloValue % 2 == 0) {
                                imageViewX.setVisible(true);
                                Board.setBoardElementValue(1, row, col);
                            }
                            else {
                                imageViewO.setVisible(true);
                                Board.setBoardElementValue(2, row, col); 
                            }

                            // Game ends
                            if ( Board.didXWin() == true ) {
                                xText.setVisible(true);
                                button.setVisible(true);
                                
                                // Fill the remaining boxes with an empty box
                                int index = 0;
                                for ( int currRow = 0; currRow < 4; currRow++ ) {
                                    for ( int currCol = 0; currCol <4; currCol++ ) {
                                        Pane pane = (Pane)gridPane.getChildren().get(index);
                                        if ( Board.getBoardElementValue(currRow, currCol) == 0 ) {
                                            pane.getChildren().get(3).setVisible(true);
                                        }
                                        index++;
                                    }
                                }
                            }
                            else if ( Board.didOWin() == true ) {
                                oText.setVisible(true);
                                button.setVisible(true);

                                // Fill the remaining boxes with an empty box
                                int index = 0;
                                for ( int currRow = 0; currRow < 4; currRow++ ) {
                                    for ( int currCol = 0; currCol <4; currCol++ ) {
                                        Pane pane = (Pane)gridPane.getChildren().get(index);
                                        if ( Board.getBoardElementValue(currRow, currCol) == 0 ) {
                                            pane.getChildren().get(3).setVisible(true);
                                        }
                                        index++;
                                    }
                                }
                            }
                            else if ( moduloValue == 15 ) {
                                drawText.setVisible(true);
                                button.setVisible(true);
                            }

                            moduloValue++;       
                        } 
                    };  
                    
                    // Adding the event handler 
                    rectangle.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandler);
                } 
                catch (FileNotFoundException e) {
                    System.out.println("Error: Cannot find the file!");
                    System.exit(-1);
                }
            }
        }
    
        gridPane.setPadding(new Insets(25, 45, 10, 45));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        
        EventHandler<javafx.scene.input.MouseEvent> buttonClickHandler = 
            new EventHandler<javafx.scene.input.MouseEvent>() { 
                        
            @Override 
            public void handle(javafx.scene.input.MouseEvent e) { 
                int index = 0;
                for ( int currRow = 0; currRow < 4; currRow++ ) {
                    for ( int currCol = 0; currCol <4; currCol++ ) {
                        Pane pane = (Pane)gridPane.getChildren().get(index);
                        pane.getChildren().get(1).setVisible(false);
                        pane.getChildren().get(2).setVisible(false);
                        pane.getChildren().get(3).setVisible(false);
                        index++;
                    }
                }

                textPane.getChildren().get(0).setVisible(false);
                textPane.getChildren().get(1).setVisible(false);
                textPane.getChildren().get(2).setVisible(false);

                button.setVisible(false);

                Board.clearBoard();
                moduloValue = 0;
            };  
        };
                    
        //Adding the event handler 
        button.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, buttonClickHandler);

        VBox vBox = new VBox(gridPane, textPane, button);    
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0, 0, 30, 0));
        Color myDarkBlue = Color.rgb(55, 93, 138);
        vBox.setBorder(new Border(new BorderStroke(myDarkBlue, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3.5))));
        
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);

        // Show the window
        primaryStage.show();
    }
}
